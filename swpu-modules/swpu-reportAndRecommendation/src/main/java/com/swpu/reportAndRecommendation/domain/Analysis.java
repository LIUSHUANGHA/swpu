package com.swpu.reportAndRecommendation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 行为数据分析对象 analysis
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Analysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工人id */
    @Excel(name = "工人id")
    private Integer peopleId;

    /** 分析id */
    private Integer analysisId;

    /** 分析结果 */
    @Excel(name = "分析结果")
    private String analysisResult;

    public void setPeopleId(Integer peopleId) 
    {
        this.peopleId = peopleId;
    }

    public Integer getPeopleId() 
    {
        return peopleId;
    }
    public void setAnalysisId(Integer analysisId) 
    {
        this.analysisId = analysisId;
    }

    public Integer getAnalysisId() 
    {
        return analysisId;
    }
    public void setAnalysisResult(String analysisResult) 
    {
        this.analysisResult = analysisResult;
    }

    public String getAnalysisResult() 
    {
        return analysisResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("peopleId", getPeopleId())
            .append("analysisId", getAnalysisId())
            .append("analysisResult", getAnalysisResult())
            .append("remark", getRemark())
            .toString();
    }
}
