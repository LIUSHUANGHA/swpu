package com.swpu.assessmentAndAlerting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 风险评估对象 assessment
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Assessment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评估id */
    private Integer assessmentId;

    /** 识别id */
    @Excel(name = "识别id")
    private Integer identificationId;

    /** 评估结果 */
    @Excel(name = "评估结果")
    private Integer assessmentResult;

    public void setAssessmentId(Integer assessmentId) 
    {
        this.assessmentId = assessmentId;
    }

    public Integer getAssessmentId() 
    {
        return assessmentId;
    }
    public void setIdentificationId(Integer identificationId) 
    {
        this.identificationId = identificationId;
    }

    public Integer getIdentificationId() 
    {
        return identificationId;
    }
    public void setAssessmentResult(Integer assessmentResult) 
    {
        this.assessmentResult = assessmentResult;
    }

    public Integer getAssessmentResult() 
    {
        return assessmentResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("assessmentId", getAssessmentId())
            .append("identificationId", getIdentificationId())
            .append("assessmentResult", getAssessmentResult())
            .append("remark", getRemark())
            .toString();
    }
}
