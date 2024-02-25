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
import com.swpu.assessmentAndAlerting.domain.Assessment;
import com.swpu.assessmentAndAlerting.service.IAssessmentService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 风险评估Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/assessment")
public class AssessmentController extends BaseController
{
    @Autowired
    private IAssessmentService assessmentService;

    /**
     * 查询风险评估列表
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:list")
    @GetMapping("/list")
    public TableDataInfo list(Assessment assessment)
    {
        startPage();
        List<Assessment> list = assessmentService.selectAssessmentList(assessment);
        return getDataTable(list);
    }

    /**
     * 导出风险评估列表
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:export")
    @Log(title = "风险评估", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Assessment assessment)
    {
        List<Assessment> list = assessmentService.selectAssessmentList(assessment);
        ExcelUtil<Assessment> util = new ExcelUtil<Assessment>(Assessment.class);
        util.exportExcel(response, list, "风险评估数据");
    }

    /**
     * 获取风险评估详细信息
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:query")
    @GetMapping(value = "/{assessmentId}")
    public AjaxResult getInfo(@PathVariable("assessmentId") Integer assessmentId)
    {
        return success(assessmentService.selectAssessmentByAssessmentId(assessmentId));
    }

    /**
     * 新增风险评估
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:add")
    @Log(title = "风险评估", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Assessment assessment)
    {
        return toAjax(assessmentService.insertAssessment(assessment));
    }

    /**
     * 修改风险评估
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:edit")
    @Log(title = "风险评估", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Assessment assessment)
    {
        return toAjax(assessmentService.updateAssessment(assessment));
    }

    /**
     * 删除风险评估
     */
    @RequiresPermissions("assessmentAndAlerting:assessment:remove")
    @Log(title = "风险评估", businessType = BusinessType.DELETE)
	@DeleteMapping("/{assessmentIds}")
    public AjaxResult remove(@PathVariable Integer[] assessmentIds)
    {
        return toAjax(assessmentService.deleteAssessmentByAssessmentIds(assessmentIds));
    }
}
