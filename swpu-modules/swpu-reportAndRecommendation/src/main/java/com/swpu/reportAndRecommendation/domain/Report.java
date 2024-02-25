package com.swpu.reportAndRecommendation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 报告生成对象 report
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Report extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报告id */
    private Integer reportid;

    /** 报告内容 */
    @Excel(name = "报告内容")
    private String reportContent;

    public void setReportid(Integer reportid) 
    {
        this.reportid = reportid;
    }

    public Integer getReportid() 
    {
        return reportid;
    }
    public void setReportContent(String reportContent) 
    {
        this.reportContent = reportContent;
    }

    public String getReportContent() 
    {
        return reportContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reportid", getReportid())
            .append("reportContent", getReportContent())
            .toString();
    }
}
