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
import com.swpu.reportAndRecommendation.domain.Analysis;
import com.swpu.reportAndRecommendation.service.IAnalysisService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 行为数据分析Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController extends BaseController
{
    @Autowired
    private IAnalysisService analysisService;

    /**
     * 查询行为数据分析列表
     */
    @RequiresPermissions("reportAndRecommendation:analysis:list")
    @GetMapping("/list")
    public TableDataInfo list(Analysis analysis)
    {
        startPage();
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        return getDataTable(list);
    }

    /**
     * 导出行为数据分析列表
     */
    @RequiresPermissions("reportAndRecommendation:analysis:export")
    @Log(title = "行为数据分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Analysis analysis)
    {
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        ExcelUtil<Analysis> util = new ExcelUtil<Analysis>(Analysis.class);
        util.exportExcel(response, list, "行为数据分析数据");
    }

    /**
     * 获取行为数据分析详细信息
     */
    @RequiresPermissions("reportAndRecommendation:analysis:query")
    @GetMapping(value = "/{analysisId}")
    public AjaxResult getInfo(@PathVariable("analysisId") Integer analysisId)
    {
        return success(analysisService.selectAnalysisByAnalysisId(analysisId));
    }

    /**
     * 新增行为数据分析
     */
    @RequiresPermissions("reportAndRecommendation:analysis:add")
    @Log(title = "行为数据分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.insertAnalysis(analysis));
    }

    /**
     * 修改行为数据分析
     */
    @RequiresPermissions("reportAndRecommendation:analysis:edit")
    @Log(title = "行为数据分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Analysis analysis)
    {
        return toAjax(analysisService.updateAnalysis(analysis));
    }

    /**
     * 删除行为数据分析
     */
    @RequiresPermissions("reportAndRecommendation:analysis:remove")
    @Log(title = "行为数据分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{analysisIds}")
    public AjaxResult remove(@PathVariable Integer[] analysisIds)
    {
        return toAjax(analysisService.deleteAnalysisByAnalysisIds(analysisIds));
    }
}
