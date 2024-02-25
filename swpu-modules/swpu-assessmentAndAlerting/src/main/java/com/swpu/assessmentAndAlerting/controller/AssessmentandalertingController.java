package com.swpu.assessmentAndAlerting.controller;

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
import com.swpu.assessmentAndAlerting.domain.Assessmentandalerting;
import com.swpu.assessmentAndAlerting.service.IAssessmentandalertingService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 风险评估和告警Controller
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@RestController
@RequestMapping("/assessmentandalerting")
public class AssessmentandalertingController extends BaseController
{
    @Autowired
    private IAssessmentandalertingService assessmentandalertingService;

    /**
     * 查询风险评估和告警列表
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:list")
    @GetMapping("/list")
    public TableDataInfo list(Assessmentandalerting assessmentandalerting)
    {
        startPage();
        List<Assessmentandalerting> list = assessmentandalertingService.selectAssessmentandalertingList(assessmentandalerting);
        return getDataTable(list);
    }

    /**
     * 导出风险评估和告警列表
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:export")
    @Log(title = "风险评估和告警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Assessmentandalerting assessmentandalerting)
    {
        List<Assessmentandalerting> list = assessmentandalertingService.selectAssessmentandalertingList(assessmentandalerting);
        ExcelUtil<Assessmentandalerting> util = new ExcelUtil<Assessmentandalerting>(Assessmentandalerting.class);
        util.exportExcel(response, list, "风险评估和告警数据");
    }

    /**
     * 获取风险评估和告警详细信息
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:query")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(assessmentandalertingService.selectAssessmentandalertingByStudentId(studentId));
    }

    /**
     * 新增风险评估和告警
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:add")
    @Log(title = "风险评估和告警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Assessmentandalerting assessmentandalerting)
    {
        return toAjax(assessmentandalertingService.insertAssessmentandalerting(assessmentandalerting));
    }

    /**
     * 修改风险评估和告警
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:edit")
    @Log(title = "风险评估和告警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Assessmentandalerting assessmentandalerting)
    {
        return toAjax(assessmentandalertingService.updateAssessmentandalerting(assessmentandalerting));
    }

    /**
     * 删除风险评估和告警
     */
    @RequiresPermissions("assessmentAndAlerting:assessmentandalerting:remove")
    @Log(title = "风险评估和告警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(assessmentandalertingService.deleteAssessmentandalertingByStudentIds(studentIds));
    }
}
