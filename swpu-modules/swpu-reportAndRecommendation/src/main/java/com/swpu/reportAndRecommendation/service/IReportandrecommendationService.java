package com.swpu.reportAndRecommendation.service;

import java.util.List;
import com.swpu.reportAndRecommendation.domain.Reportandrecommendation;

/**
 * 行为分析报告和改进建议Service接口
 * 
 * @author liushuang
 * @date 2024-02-01
 */
public interface IReportandrecommendationService 
{
    /**
     * 查询行为分析报告和改进建议
     * 
     * @param studentId 行为分析报告和改进建议主键
     * @return 行为分析报告和改进建议
     */
    public Reportandrecommendation selectReportandrecommendationByStudentId(Long studentId);

    /**
     * 查询行为分析报告和改进建议列表
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 行为分析报告和改进建议集合
     */
    public List<Reportandrecommendation> selectReportandrecommendationList(Reportandrecommendation reportandrecommendation);

    /**
     * 新增行为分析报告和改进建议
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 结果
     */
    public int insertReportandrecommendation(Reportandrecommendation reportandrecommendation);

    /**
     * 修改行为分析报告和改进建议
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 结果
     */
    public int updateReportandrecommendation(Reportandrecommendation reportandrecommendation);

    /**
     * 批量删除行为分析报告和改进建议
     * 
     * @param studentIds 需要删除的行为分析报告和改进建议主键集合
     * @return 结果
     */
    public int deleteReportandrecommendationByStudentIds(Long[] studentIds);

    /**
     * 删除行为分析报告和改进建议信息
     * 
     * @param studentId 行为分析报告和改进建议主键
     * @return 结果
     */
    public int deleteReportandrecommendationByStudentId(Long studentId);
}
