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
import com.swpu.identification.domain.Cameraaccess;
import com.swpu.identification.service.ICameraaccessService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 摄像头接入Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/cameraaccess")
public class CameraaccessController extends BaseController
{
    @Autowired
    private ICameraaccessService cameraaccessService;

    /**
     * 查询摄像头接入列表
     */
    @RequiresPermissions("identification:cameraaccess:list")
    @GetMapping("/list")
    public TableDataInfo list(Cameraaccess cameraaccess)
    {
        startPage();
        List<Cameraaccess> list = cameraaccessService.selectCameraaccessList(cameraaccess);
        return getDataTable(list);
    }

    /**
     * 导出摄像头接入列表
     */
    @RequiresPermissions("identification:cameraaccess:export")
    @Log(title = "摄像头接入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Cameraaccess cameraaccess)
    {
        List<Cameraaccess> list = cameraaccessService.selectCameraaccessList(cameraaccess);
        ExcelUtil<Cameraaccess> util = new ExcelUtil<Cameraaccess>(Cameraaccess.class);
        util.exportExcel(response, list, "摄像头接入数据");
    }

    /**
     * 获取摄像头接入详细信息
     */
    @RequiresPermissions("identification:cameraaccess:query")
    @GetMapping(value = "/{cameraId}")
    public AjaxResult getInfo(@PathVariable("cameraId") Integer cameraId)
    {
        return success(cameraaccessService.selectCameraaccessByCameraId(cameraId));
    }

    /**
     * 新增摄像头接入
     */
    @RequiresPermissions("identification:cameraaccess:add")
    @Log(title = "摄像头接入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Cameraaccess cameraaccess)
    {
        return toAjax(cameraaccessService.insertCameraaccess(cameraaccess));
    }

    /**
     * 修改摄像头接入
     */
    @RequiresPermissions("identification:cameraaccess:edit")
    @Log(title = "摄像头接入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Cameraaccess cameraaccess)
    {
        return toAjax(cameraaccessService.updateCameraaccess(cameraaccess));
    }

    /**
     * 删除摄像头接入
     */
    @RequiresPermissions("identification:cameraaccess:remove")
    @Log(title = "摄像头接入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cameraIds}")
    public AjaxResult remove(@PathVariable Integer[] cameraIds)
    {
        return toAjax(cameraaccessService.deleteCameraaccessByCameraIds(cameraIds));
    }
}
