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
import com.swpu.identification.domain.Identification;
import com.swpu.identification.service.IIdentificationService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 工人异常行为识别Controller
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@RestController
@RequestMapping("/identification")
public class IdentificationController extends BaseController
{
    @Autowired
    private IIdentificationService identificationService;

    /**
     * 查询工人异常行为识别列表
     */
    @RequiresPermissions("identification:identification:list")
    @GetMapping("/list")
    public TableDataInfo list(Identification identification)
    {
        startPage();
        List<Identification> list = identificationService.selectIdentificationList(identification);
        return getDataTable(list);
    }

    /**
     * 导出工人异常行为识别列表
     */
    @RequiresPermissions("identification:identification:export")
    @Log(title = "工人异常行为识别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Identification identification)
    {
        List<Identification> list = identificationService.selectIdentificationList(identification);
        ExcelUtil<Identification> util = new ExcelUtil<Identification>(Identification.class);
        util.exportExcel(response, list, "工人异常行为识别数据");
    }

    /**
     * 获取工人异常行为识别详细信息
     */
    @RequiresPermissions("identification:identification:query")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(identificationService.selectIdentificationByStudentId(studentId));
    }

    /**
     * 新增工人异常行为识别
     */
    @RequiresPermissions("identification:identification:add")
    @Log(title = "工人异常行为识别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Identification identification)
    {
        return toAjax(identificationService.insertIdentification(identification));
    }

    /**
     * 修改工人异常行为识别
     */
    @RequiresPermissions("identification:identification:edit")
    @Log(title = "工人异常行为识别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Identification identification)
    {
        return toAjax(identificationService.updateIdentification(identification));
    }

    /**
     * 删除工人异常行为识别
     */
    @RequiresPermissions("identification:identification:remove")
    @Log(title = "工人异常行为识别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(identificationService.deleteIdentificationByStudentIds(studentIds));
    }
}
