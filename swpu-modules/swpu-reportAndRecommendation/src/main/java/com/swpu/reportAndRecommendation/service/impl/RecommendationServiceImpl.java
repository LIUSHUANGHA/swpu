package com.swpu.reportAndRecommendation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.reportAndRecommendation.mapper.RecommendationMapper;
import com.swpu.reportAndRecommendation.domain.Recommendation;
import com.swpu.reportAndRecommendation.service.IRecommendationService;

/**
 * 改进建议Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class RecommendationServiceImpl implements IRecommendationService 
{
    @Autowired
    private RecommendationMapper recommendationMapper;

    /**
     * 查询改进建议
     * 
     * @param recommendationId 改进建议主键
     * @return 改进建议
     */
    @Override
    public Recommendation selectRecommendationByRecommendationId(Integer recommendationId)
    {
        return recommendationMapper.selectRecommendationByRecommendationId(recommendationId);
    }

    /**
     * 查询改进建议列表
     * 
     * @param recommendation 改进建议
     * @return 改进建议
     */
    @Override
    public List<Recommendation> selectRecommendationList(Recommendation recommendation)
    {
        return recommendationMapper.selectRecommendationList(recommendation);
    }

    /**
     * 新增改进建议
     * 
     * @param recommendation 改进建议
     * @return 结果
     */
    @Override
    public int insertRecommendation(Recommendation recommendation)
    {
        return recommendationMapper.insertRecommendation(recommendation);
    }

    /**
     * 修改改进建议
     * 
     * @param recommendation 改进建议
     * @return 结果
     */
    @Override
    public int updateRecommendation(Recommendation recommendation)
    {
        return recommendationMapper.updateRecommendation(recommendation);
    }

    /**
     * 批量删除改进建议
     * 
     * @param recommendationIds 需要删除的改进建议主键
     * @return 结果
     */
    @Override
    public int deleteRecommendationByRecommendationIds(Integer[] recommendationIds)
    {
        return recommendationMapper.deleteRecommendationByRecommendationIds(recommendationIds);
    }

    /**
     * 删除改进建议信息
     * 
     * @param recommendationId 改进建议主键
     * @return 结果
     */
    @Override
    public int deleteRecommendationByRecommendationId(Integer recommendationId)
    {
        return recommendationMapper.deleteRecommendationByRecommendationId(recommendationId);
    }
}
