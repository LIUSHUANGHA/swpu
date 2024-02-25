package com.swpu.reportAndRecommendation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.reportAndRecommendation.mapper.AnalysisMapper;
import com.swpu.reportAndRecommendation.domain.Analysis;
import com.swpu.reportAndRecommendation.service.IAnalysisService;

/**
 * 行为数据分析Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class AnalysisServiceImpl implements IAnalysisService 
{
    @Autowired
    private AnalysisMapper analysisMapper;

    /**
     * 查询行为数据分析
     * 
     * @param analysisId 行为数据分析主键
     * @return 行为数据分析
     */
    @Override
    public Analysis selectAnalysisByAnalysisId(Integer analysisId)
    {
        return analysisMapper.selectAnalysisByAnalysisId(analysisId);
    }

    /**
     * 查询行为数据分析列表
     * 
     * @param analysis 行为数据分析
     * @return 行为数据分析
     */
    @Override
    public List<Analysis> selectAnalysisList(Analysis analysis)
    {
        return analysisMapper.selectAnalysisList(analysis);
    }

    /**
     * 新增行为数据分析
     * 
     * @param analysis 行为数据分析
     * @return 结果
     */
    @Override
    public int insertAnalysis(Analysis analysis)
    {
        return analysisMapper.insertAnalysis(analysis);
    }

    /**
     * 修改行为数据分析
     * 
     * @param analysis 行为数据分析
     * @return 结果
     */
    @Override
    public int updateAnalysis(Analysis analysis)
    {
        return analysisMapper.updateAnalysis(analysis);
    }

    /**
     * 批量删除行为数据分析
     * 
     * @param analysisIds 需要删除的行为数据分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisIds(Integer[] analysisIds)
    {
        return analysisMapper.deleteAnalysisByAnalysisIds(analysisIds);
    }

    /**
     * 删除行为数据分析信息
     * 
     * @param analysisId 行为数据分析主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisId(Integer analysisId)
    {
        return analysisMapper.deleteAnalysisByAnalysisId(analysisId);
    }
}
