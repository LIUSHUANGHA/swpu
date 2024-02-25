package com.swpu.reportAndRecommendation.controller;

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
import com.swpu.reportAndRecommendation.domain.Reportandrecommendation;
import com.swpu.reportAndRecommendation.service.IReportandrecommendationService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 行为分析报告和改进建议Controller
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@RestController
@RequestMapping("/reportandrecommendation")
public class ReportandrecommendationController extends BaseController
{
    @Autowired
    private IReportandrecommendationService reportandrecommendationService;

    /**
     * 查询行为分析报告和改进建议列表
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:list")
    @GetMapping("/list")
    public TableDataInfo list(Reportandrecommendation reportandrecommendation)
    {
        startPage();
        List<Reportandrecommendation> list = reportandrecommendationService.selectReportandrecommendationList(reportandrecommendation);
        return getDataTable(list);
    }

    /**
     * 导出行为分析报告和改进建议列表
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:export")
    @Log(title = "行为分析报告和改进建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Reportandrecommendation reportandrecommendation)
    {
        List<Reportandrecommendation> list = reportandrecommendationService.selectReportandrecommendationList(reportandrecommendation);
        ExcelUtil<Reportandrecommendation> util = new ExcelUtil<Reportandrecommendation>(Reportandrecommendation.class);
        util.exportExcel(response, list, "行为分析报告和改进建议数据");
    }

    /**
     * 获取行为分析报告和改进建议详细信息
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:query")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(reportandrecommendationService.selectReportandrecommendationByStudentId(studentId));
    }

    /**
     * 新增行为分析报告和改进建议
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:add")
    @Log(title = "行为分析报告和改进建议", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Reportandrecommendation reportandrecommendation)
    {
        return toAjax(reportandrecommendationService.insertReportandrecommendation(reportandrecommendation));
    }

    /**
     * 修改行为分析报告和改进建议
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:edit")
    @Log(title = "行为分析报告和改进建议", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Reportandrecommendation reportandrecommendation)
    {
        return toAjax(reportandrecommendationService.updateReportandrecommendation(reportandrecommendation));
    }

    /**
     * 删除行为分析报告和改进建议
     */
    @RequiresPermissions("reportAndRecommendation:reportandrecommendation:remove")
    @Log(title = "行为分析报告和改进建议", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(reportandrecommendationService.deleteReportandrecommendationByStudentIds(studentIds));
    }
}
