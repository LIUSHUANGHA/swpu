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
import com.swpu.reportAndRecommendation.domain.Recommendation;
import com.swpu.reportAndRecommendation.service.IRecommendationService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 改进建议Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/recommendation")
public class RecommendationController extends BaseController
{
    @Autowired
    private IRecommendationService recommendationService;

    /**
     * 查询改进建议列表
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:list")
    @GetMapping("/list")
    public TableDataInfo list(Recommendation recommendation)
    {
        startPage();
        List<Recommendation> list = recommendationService.selectRecommendationList(recommendation);
        return getDataTable(list);
    }

    /**
     * 导出改进建议列表
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:export")
    @Log(title = "改进建议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Recommendation recommendation)
    {
        List<Recommendation> list = recommendationService.selectRecommendationList(recommendation);
        ExcelUtil<Recommendation> util = new ExcelUtil<Recommendation>(Recommendation.class);
        util.exportExcel(response, list, "改进建议数据");
    }

    /**
     * 获取改进建议详细信息
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:query")
    @GetMapping(value = "/{recommendationId}")
    public AjaxResult getInfo(@PathVariable("recommendationId") Integer recommendationId)
    {
        return success(recommendationService.selectRecommendationByRecommendationId(recommendationId));
    }

    /**
     * 新增改进建议
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:add")
    @Log(title = "改进建议", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Recommendation recommendation)
    {
        return toAjax(recommendationService.insertRecommendation(recommendation));
    }

    /**
     * 修改改进建议
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:edit")
    @Log(title = "改进建议", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Recommendation recommendation)
    {
        return toAjax(recommendationService.updateRecommendation(recommendation));
    }

    /**
     * 删除改进建议
     */
    @RequiresPermissions("reportAndRecommendation:recommendation:remove")
    @Log(title = "改进建议", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recommendationIds}")
    public AjaxResult remove(@PathVariable Integer[] recommendationIds)
    {
        return toAjax(recommendationService.deleteRecommendationByRecommendationIds(recommendationIds));
    }
}
