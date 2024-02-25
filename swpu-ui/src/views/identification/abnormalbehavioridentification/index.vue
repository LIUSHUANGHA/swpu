<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="数据id" prop="dataId">
        <el-input
          v-model="queryParams.dataId"
          placeholder="请输入数据id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="识别进程" prop="identificationProcess">
        <el-select v-model="queryParams.identificationProcess" placeholder="请选择识别进程" clearable>
          <el-option
            v-for="dict in dict.type.data_process_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="管理员判定工人id进程" prop="peopleProcess">
        <el-select v-model="queryParams.peopleProcess" placeholder="请选择管理员判定工人id进程" clearable>
          <el-option
            v-for="dict in dict.type.data_process_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="识别时间" prop="identificationTime">
        <el-date-picker clearable
          v-model="queryParams.identificationTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择识别时间">
        </el-date-picker>
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
          v-hasPermi="['identification:abnormalbehavioridentification:add']"
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
          v-hasPermi="['identification:abnormalbehavioridentification:edit']"
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
          v-hasPermi="['identification:abnormalbehavioridentification:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['identification:abnormalbehavioridentification:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="abnormalbehavioridentificationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="识别id" align="center" prop="identificationId" />
      <el-table-column label="数据id" align="center" prop="dataId" />
      <el-table-column label="识别进程" align="center" prop="identificationProcess">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.data_process_status" :value="scope.row.identificationProcess"/>
        </template>
      </el-table-column>
      <el-table-column label="管理员判定工人id进程" align="center" prop="peopleProcess">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.data_process_status" :value="scope.row.peopleProcess"/>
        </template>
      </el-table-column>
      <el-table-column label="识别时间" align="center" prop="identificationTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.identificationTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['identification:abnormalbehavioridentification:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['identification:abnormalbehavioridentification:remove']"
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

    <!-- 添加或修改异常行为识别对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="数据id" prop="dataId">
          <el-input v-model="form.dataId" placeholder="请输入数据id" />
        </el-form-item>
        <el-form-item label="识别进程" prop="identificationProcess">
          <el-radio-group v-model="form.identificationProcess">
            <el-radio
              v-for="dict in dict.type.data_process_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="管理员判定工人id进程" prop="peopleProcess">
          <el-radio-group v-model="form.peopleProcess">
            <el-radio
              v-for="dict in dict.type.data_process_status"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="识别时间" prop="identificationTime">
          <el-date-picker clearable
            v-model="form.identificationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择识别时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listAbnormalbehavioridentification, getAbnormalbehavioridentification, delAbnormalbehavioridentification, addAbnormalbehavioridentification, updateAbnormalbehavioridentification } from "@/api/identification/abnormalbehavioridentification";

export default {
  name: "Abnormalbehavioridentification",
  dicts: ['data_process_status'],
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
      // 异常行为识别表格数据
      abnormalbehavioridentificationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dataId: null,
        identificationProcess: null,
        peopleProcess: null,
        identificationTime: null,
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
    /** 查询异常行为识别列表 */
    getList() {
      this.loading = true;
      listAbnormalbehavioridentification(this.queryParams).then(response => {
        this.abnormalbehavioridentificationList = response.rows;
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
        identificationId: null,
        dataId: null,
        identificationProcess: null,
        peopleProcess: null,
        identificationTime: null,
        remark: null
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
      this.ids = selection.map(item => item.identificationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加异常行为识别";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const identificationId = row.identificationId || this.ids
      getAbnormalbehavioridentification(identificationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改异常行为识别";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.identificationId != null) {
            updateAbnormalbehavioridentification(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAbnormalbehavioridentification(this.form).then(response => {
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
      const identificationIds = row.identificationId || this.ids;
      this.$modal.confirm('是否确认删除异常行为识别编号为"' + identificationIds + '"的数据项？').then(function() {
        return delAbnormalbehavioridentification(identificationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('identification/abnormalbehavioridentification/export', {
        ...this.queryParams
      }, `abnormalbehavioridentification_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
