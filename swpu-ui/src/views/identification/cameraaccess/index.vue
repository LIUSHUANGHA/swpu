<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="摄像头名称" prop="cameraName">
        <el-input
          v-model="queryParams.cameraName"
          placeholder="请输入摄像头名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="安装位置" prop="installLocation">
        <el-input
          v-model="queryParams.installLocation"
          placeholder="请输入安装位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连接状态" prop="connectionStatus">
        <el-select v-model="queryParams.connectionStatus" placeholder="请选择连接状态" clearable>
          <el-option
            v-for="dict in dict.type.camera_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['identification:cameraaccess:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['identification:cameraaccess:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['identification:cameraaccess:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['identification:cameraaccess:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cameraaccessList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="摄像头id" align="center" prop="cameraId" />
      <el-table-column label="摄像头名称" align="center" prop="cameraName" />
      <el-table-column label="安装位置" align="center" prop="installLocation" />
      <el-table-column label="ip地址" align="center" prop="ipLocation" />
      <el-table-column label="端口号" align="center" prop="portNumber" />
      <el-table-column label="连接状态" align="center" prop="connectionStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.camera_status" :value="scope.row.connectionStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="最后更新时间" align="center" prop="lastUpdated" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastUpdated, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['identification:cameraaccess:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['identification:cameraaccess:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改摄像头接入对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="摄像头名称" prop="cameraName">
          <el-input v-model="form.cameraName" placeholder="请输入摄像头名称" />
        </el-form-item>
        <el-form-item label="安装位置" prop="installLocation">
          <el-input v-model="form.installLocation" placeholder="请输入安装位置" />
        </el-form-item>
        <el-form-item label="ip地址" prop="ipLocation">
          <el-input v-model="form.ipLocation" placeholder="请输入ip地址" />
        </el-form-item>
        <el-form-item label="端口号" prop="portNumber">
          <el-input v-model="form.portNumber" placeholder="请输入端口号" />
        </el-form-item>
        <el-form-item label="连接状态" prop="connectionStatus">
          <el-radio-group v-model="form.connectionStatus">
            <el-radio
              v-for="dict in dict.type.camera_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="最后更新时间" prop="lastUpdated">
          <el-date-picker clearable
            v-model="form.lastUpdated"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后更新时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCameraaccess, getCameraaccess, delCameraaccess, addCameraaccess, updateCameraaccess } from "@/api/identification/cameraaccess";

export default {
  name: "Cameraaccess",
  dicts: ['camera_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 摄像头接入表格数据
      cameraaccessList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cameraName: null,
        installLocation: null,
        connectionStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询摄像头接入列表 */
    getList() {
      this.loading = true;
      listCameraaccess(this.queryParams).then(response => {
        this.cameraaccessList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        cameraId: null,
        cameraName: null,
        installLocation: null,
        ipLocation: null,
        portNumber: null,
        connectionStatus: null,
        lastUpdated: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.cameraId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加摄像头接入";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const cameraId = row.cameraId || this.ids
      getCameraaccess(cameraId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改摄像头接入";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.cameraId != null) {
            updateCameraaccess(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCameraaccess(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const cameraIds = row.cameraId || this.ids;
      this.$modal.confirm('是否确认删除摄像头接入编号为"' + cameraIds + '"的数据项？').then(function() {
        return delCameraaccess(cameraIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('identification/cameraaccess/export', {
        ...this.queryParams
      }, `cameraaccess_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
