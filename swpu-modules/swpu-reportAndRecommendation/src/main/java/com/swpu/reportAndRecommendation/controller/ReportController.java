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
import com.swpu.reportAndRecommendation.domain.Report;
import com.swpu.reportAndRecommendation.service.IReportService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 报告生成Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/report")
public class ReportController extends BaseController
{
    @Autowired
    private IReportService reportService;

    /**
     * 查询报告生成列表
     */
    @RequiresPermissions("reportAndRecommendation:report:list")
    @GetMapping("/list")
    public TableDataInfo list(Report report)
    {
        startPage();
        List<Report> list = reportService.selectReportList(report);
        return getDataTable(list);
    }

    /**
     * 导出报告生成列表
     */
    @RequiresPermissions("reportAndRecommendation:report:export")
    @Log(title = "报告生成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Report report)
    {
        List<Report> list = reportService.selectReportList(report);
        ExcelUtil<Report> util = new ExcelUtil<Report>(Report.class);
        util.exportExcel(response, list, "报告生成数据");
    }

    /**
     * 获取报告生成详细信息
     */
    @RequiresPermissions("reportAndRecommendation:report:query")
    @GetMapping(value = "/{reportid}")
    public AjaxResult getInfo(@PathVariable("reportid") Integer reportid)
    {
        return success(reportService.selectReportByReportid(reportid));
    }

    /**
     * 新增报告生成
     */
    @RequiresPermissions("reportAndRecommendation:report:add")
    @Log(title = "报告生成", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Report report)
    {
        return toAjax(reportService.insertReport(report));
    }

    /**
     * 修改报告生成
     */
    @RequiresPermissions("reportAndRecommendation:report:edit")
    @Log(title = "报告生成", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Report report)
    {
        return toAjax(reportService.updateReport(report));
    }

    /**
     * 删除报告生成
     */
    @RequiresPermissions("reportAndRecommendation:report:remove")
    @Log(title = "报告生成", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportids}")
    public AjaxResult remove(@PathVariable Integer[] reportids)
    {
        return toAjax(reportService.deleteReportByReportids(reportids));
    }
}
