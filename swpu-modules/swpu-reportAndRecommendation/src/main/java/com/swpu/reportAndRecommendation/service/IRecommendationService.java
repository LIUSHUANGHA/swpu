package com.swpu.reportAndRecommendation.service;

import java.util.List;
import com.swpu.reportAndRecommendation.domain.Recommendation;

/**
 * 改进建议Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IRecommendationService 
{
    /**
     * 查询改进建议
     * 
     * @param recommendationId 改进建议主键
     * @return 改进建议
     */
    public Recommendation selectRecommendationByRecommendationId(Integer recommendationId);

    /**
     * 查询改进建议列表
     * 
     * @param recommendation 改进建议
     * @return 改进建议集合
     */
    public List<Recommendation> selectRecommendationList(Recommendation recommendation);

    /**
     * 新增改进建议
     * 
     * @param recommendation 改进建议
     * @return 结果
     */
    public int insertRecommendation(Recommendation recommendation);

    /**
     * 修改改进建议
     * 
     * @param recommendation 改进建议
     * @return 结果
     */
    public int updateRecommendation(Recommendation recommendation);

    /**
     * 批量删除改进建议
     * 
     * @param recommendationIds 需要删除的改进建议主键集合
     * @return 结果
     */
    public int deleteRecommendationByRecommendationIds(Integer[] recommendationIds);

    /**
     * 删除改进建议信息
     * 
     * @param recommendationId 改进建议主键
     * @return 结果
     */
    public int deleteRecommendationByRecommendationId(Integer recommendationId);
}
