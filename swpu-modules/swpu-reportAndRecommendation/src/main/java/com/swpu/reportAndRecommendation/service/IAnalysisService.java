package com.swpu.reportAndRecommendation.service;

import java.util.List;
import com.swpu.reportAndRecommendation.domain.Analysis;

/**
 * 行为数据分析Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IAnalysisService 
{
    /**
     * 查询行为数据分析
     * 
     * @param analysisId 行为数据分析主键
     * @return 行为数据分析
     */
    public Analysis selectAnalysisByAnalysisId(Integer analysisId);

    /**
     * 查询行为数据分析列表
     * 
     * @param analysis 行为数据分析
     * @return 行为数据分析集合
     */
    public List<Analysis> selectAnalysisList(Analysis analysis);

    /**
     * 新增行为数据分析
     * 
     * @param analysis 行为数据分析
     * @return 结果
     */
    public int insertAnalysis(Analysis analysis);

    /**
     * 修改行为数据分析
     * 
     * @param analysis 行为数据分析
     * @return 结果
     */
    public int updateAnalysis(Analysis analysis);

    /**
     * 批量删除行为数据分析
     * 
     * @param analysisIds 需要删除的行为数据分析主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalysisIds(Integer[] analysisIds);

    /**
     * 删除行为数据分析信息
     * 
     * @param analysisId 行为数据分析主键
     * @return 结果
     */
    public int deleteAnalysisByAnalysisId(Integer analysisId);
}
