package com.swpu.reportAndRecommendation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.reportAndRecommendation.mapper.ReportandrecommendationMapper;
import com.swpu.reportAndRecommendation.domain.Reportandrecommendation;
import com.swpu.reportAndRecommendation.service.IReportandrecommendationService;

/**
 * 行为分析报告和改进建议Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@Service
public class ReportandrecommendationServiceImpl implements IReportandrecommendationService 
{
    @Autowired
    private ReportandrecommendationMapper reportandrecommendationMapper;

    /**
     * 查询行为分析报告和改进建议
     * 
     * @param studentId 行为分析报告和改进建议主键
     * @return 行为分析报告和改进建议
     */
    @Override
    public Reportandrecommendation selectReportandrecommendationByStudentId(Long studentId)
    {
        return reportandrecommendationMapper.selectReportandrecommendationByStudentId(studentId);
    }

    /**
     * 查询行为分析报告和改进建议列表
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 行为分析报告和改进建议
     */
    @Override
    public List<Reportandrecommendation> selectReportandrecommendationList(Reportandrecommendation reportandrecommendation)
    {
        return reportandrecommendationMapper.selectReportandrecommendationList(reportandrecommendation);
    }

    /**
     * 新增行为分析报告和改进建议
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 结果
     */
    @Override
    public int insertReportandrecommendation(Reportandrecommendation reportandrecommendation)
    {
        return reportandrecommendationMapper.insertReportandrecommendation(reportandrecommendation);
    }

    /**
     * 修改行为分析报告和改进建议
     * 
     * @param reportandrecommendation 行为分析报告和改进建议
     * @return 结果
     */
    @Override
    public int updateReportandrecommendation(Reportandrecommendation reportandrecommendation)
    {
        return reportandrecommendationMapper.updateReportandrecommendation(reportandrecommendation);
    }

    /**
     * 批量删除行为分析报告和改进建议
     * 
     * @param studentIds 需要删除的行为分析报告和改进建议主键
     * @return 结果
     */
    @Override
    public int deleteReportandrecommendationByStudentIds(Long[] studentIds)
    {
        return reportandrecommendationMapper.deleteReportandrecommendationByStudentIds(studentIds);
    }

    /**
     * 删除行为分析报告和改进建议信息
     * 
     * @param studentId 行为分析报告和改进建议主键
     * @return 结果
     */
    @Override
    public int deleteReportandrecommendationByStudentId(Long studentId)
    {
        return reportandrecommendationMapper.deleteReportandrecommendationByStudentId(studentId);
    }
}
