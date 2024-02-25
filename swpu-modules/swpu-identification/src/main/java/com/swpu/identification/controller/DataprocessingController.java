package com.swpu.identification.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swpu.common.log.annotation.Log;
import com.swpu.common.log.enums.BusinessType;
import com.swpu.common.security.annotation.RequiresPermissions;
import com.swpu.identification.domain.Dataprocessing;
import com.swpu.identification.service.IDataprocessingService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 数据处理Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/dataprocessing")
public class DataprocessingController extends BaseController
{
    @Autowired
    private IDataprocessingService dataprocessingService;

    /**
     * 查询数据处理列表
     */
    @RequiresPermissions("identification:dataprocessing:list")
    @GetMapping("/list")
    public TableDataInfo list(Dataprocessing dataprocessing)
    {
        startPage();
        List<Dataprocessing> list = dataprocessingService.selectDataprocessingList(dataprocessing);
        return getDataTable(list);
    }

    /**
     * 导出数据处理列表
     */
    @RequiresPermissions("identification:dataprocessing:export")
    @Log(title = "数据处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dataprocessing dataprocessing)
    {
        List<Dataprocessing> list = dataprocessingService.selectDataprocessingList(dataprocessing);
        ExcelUtil<Dataprocessing> util = new ExcelUtil<Dataprocessing>(Dataprocessing.class);
        util.exportExcel(response, list, "数据处理数据");
    }

    /**
     * 获取数据处理详细信息
     */
    @RequiresPermissions("identification:dataprocessing:query")
    @GetMapping(value = "/{dataId}")
    public AjaxResult getInfo(@PathVariable("dataId") Integer dataId)
    {
        return success(dataprocessingService.selectDataprocessingByDataId(dataId));
    }

    /**
     * 新增数据处理
     */
    @RequiresPermissions("identification:dataprocessing:add")
    @Log(title = "数据处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dataprocessing dataprocessing)
    {
        return toAjax(dataprocessingService.insertDataprocessing(dataprocessing));
    }

    /**
     * 修改数据处理
     */
    @RequiresPermissions("identification:dataprocessing:edit")
    @Log(title = "数据处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dataprocessing dataprocessing)
    {
        return toAjax(dataprocessingService.updateDataprocessing(dataprocessing));
    }

    /**
     * 删除数据处理
     */
    @RequiresPermissions("identification:dataprocessing:remove")
    @Log(title = "数据处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataIds}")
    public AjaxResult remove(@PathVariable Integer[] dataIds)
    {
        return toAjax(dataprocessingService.deleteDataprocessingByDataIds(dataIds));
    }
}
