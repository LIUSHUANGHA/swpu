package com.swpu.reportAndRecommendation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.reportAndRecommendation.mapper.ReportMapper;
import com.swpu.reportAndRecommendation.domain.Report;
import com.swpu.reportAndRecommendation.service.IReportService;

/**
 * 报告生成Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class ReportServiceImpl implements IReportService 
{
    @Autowired
    private ReportMapper reportMapper;

    /**
     * 查询报告生成
     * 
     * @param reportid 报告生成主键
     * @return 报告生成
     */
    @Override
    public Report selectReportByReportid(Integer reportid)
    {
        return reportMapper.selectReportByReportid(reportid);
    }

    /**
     * 查询报告生成列表
     * 
     * @param report 报告生成
     * @return 报告生成
     */
    @Override
    public List<Report> selectReportList(Report report)
    {
        return reportMapper.selectReportList(report);
    }

    /**
     * 新增报告生成
     * 
     * @param report 报告生成
     * @return 结果
     */
    @Override
    public int insertReport(Report report)
    {
        return reportMapper.insertReport(report);
    }

    /**
     * 修改报告生成
     * 
     * @param report 报告生成
     * @return 结果
     */
    @Override
    public int updateReport(Report report)
    {
        return reportMapper.updateReport(report);
    }

    /**
     * 批量删除报告生成
     * 
     * @param reportids 需要删除的报告生成主键
     * @return 结果
     */
    @Override
    public int deleteReportByReportids(Integer[] reportids)
    {
        return reportMapper.deleteReportByReportids(reportids);
    }

    /**
     * 删除报告生成信息
     * 
     * @param reportid 报告生成主键
     * @return 结果
     */
    @Override
    public int deleteReportByReportid(Integer reportid)
    {
        return reportMapper.deleteReportByReportid(reportid);
    }
}
