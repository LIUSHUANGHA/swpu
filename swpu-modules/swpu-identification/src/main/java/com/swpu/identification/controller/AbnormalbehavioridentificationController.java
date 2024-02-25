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
import com.swpu.identification.domain.Abnormalbehavioridentification;
import com.swpu.identification.service.IAbnormalbehavioridentificationService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 异常行为识别Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/abnormalbehavioridentification")
public class AbnormalbehavioridentificationController extends BaseController
{
    @Autowired
    private IAbnormalbehavioridentificationService abnormalbehavioridentificationService;

    /**
     * 查询异常行为识别列表
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:list")
    @GetMapping("/list")
    public TableDataInfo list(Abnormalbehavioridentification abnormalbehavioridentification)
    {
        startPage();
        List<Abnormalbehavioridentification> list = abnormalbehavioridentificationService.selectAbnormalbehavioridentificationList(abnormalbehavioridentification);
        return getDataTable(list);
    }

    /**
     * 导出异常行为识别列表
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:export")
    @Log(title = "异常行为识别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Abnormalbehavioridentification abnormalbehavioridentification)
    {
        List<Abnormalbehavioridentification> list = abnormalbehavioridentificationService.selectAbnormalbehavioridentificationList(abnormalbehavioridentification);
        ExcelUtil<Abnormalbehavioridentification> util = new ExcelUtil<Abnormalbehavioridentification>(Abnormalbehavioridentification.class);
        util.exportExcel(response, list, "异常行为识别数据");
    }

    /**
     * 获取异常行为识别详细信息
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:query")
    @GetMapping(value = "/{identificationId}")
    public AjaxResult getInfo(@PathVariable("identificationId") Integer identificationId)
    {
        return success(abnormalbehavioridentificationService.selectAbnormalbehavioridentificationByIdentificationId(identificationId));
    }

    /**
     * 新增异常行为识别
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:add")
    @Log(title = "异常行为识别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Abnormalbehavioridentification abnormalbehavioridentification)
    {
        return toAjax(abnormalbehavioridentificationService.insertAbnormalbehavioridentification(abnormalbehavioridentification));
    }

    /**
     * 修改异常行为识别
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:edit")
    @Log(title = "异常行为识别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Abnormalbehavioridentification abnormalbehavioridentification)
    {
        return toAjax(abnormalbehavioridentificationService.updateAbnormalbehavioridentification(abnormalbehavioridentification));
    }

    /**
     * 删除异常行为识别
     */
    @RequiresPermissions("identification:abnormalbehavioridentification:remove")
    @Log(title = "异常行为识别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{identificationIds}")
    public AjaxResult remove(@PathVariable Integer[] identificationIds)
    {
        return toAjax(abnormalbehavioridentificationService.deleteAbnormalbehavioridentificationByIdentificationIds(identificationIds));
    }
}
