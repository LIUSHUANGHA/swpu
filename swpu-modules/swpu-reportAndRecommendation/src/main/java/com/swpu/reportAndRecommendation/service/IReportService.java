package com.swpu.reportAndRecommendation.service;

import java.util.List;
import com.swpu.reportAndRecommendation.domain.Report;

/**
 * 报告生成Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IReportService 
{
    /**
     * 查询报告生成
     * 
     * @param reportid 报告生成主键
     * @return 报告生成
     */
    public Report selectReportByReportid(Integer reportid);

    /**
     * 查询报告生成列表
     * 
     * @param report 报告生成
     * @return 报告生成集合
     */
    public List<Report> selectReportList(Report report);

    /**
     * 新增报告生成
     * 
     * @param report 报告生成
     * @return 结果
     */
    public int insertReport(Report report);

    /**
     * 修改报告生成
     * 
     * @param report 报告生成
     * @return 结果
     */
    public int updateReport(Report report);

    /**
     * 批量删除报告生成
     * 
     * @param reportids 需要删除的报告生成主键集合
     * @return 结果
     */
    public int deleteReportByReportids(Integer[] reportids);

    /**
     * 删除报告生成信息
     * 
     * @param reportid 报告生成主键
     * @return 结果
     */
    public int deleteReportByReportid(Integer reportid);
}
