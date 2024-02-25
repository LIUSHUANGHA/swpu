package com.swpu.reportAndRecommendation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 改进建议对象 recommendation
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Recommendation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 建议id */
    private Integer recommendationId;

    /** 报告id */
    @Excel(name = "报告id")
    private Integer reportId;

    /** 建议内容 */
    @Excel(name = "建议内容")
    private String recommendationContent;

    public void setRecommendationId(Integer recommendationId) 
    {
        this.recommendationId = recommendationId;
    }

    public Integer getRecommendationId() 
    {
        return recommendationId;
    }
    public void setReportId(Integer reportId) 
    {
        this.reportId = reportId;
    }

    public Integer getReportId() 
    {
        return reportId;
    }
    public void setRecommendationContent(String recommendationContent) 
    {
        this.recommendationContent = recommendationContent;
    }

    public String getRecommendationContent() 
    {
        return recommendationContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recommendationId", getRecommendationId())
            .append("reportId", getReportId())
            .append("recommendationContent", getRecommendationContent())
            .toString();
    }
}
