package com.swpu.identification.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 异常行为展示对象 abnormalbehaviorshow
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Abnormalbehaviorshow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 识别id */
    private Integer identificationId;

    /** 数据id */
    @Excel(name = "数据id")
    private Integer dataId;

    /** 识别时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "识别时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date identificationTime;

    /** 识别结果 */
    @Excel(name = "识别结果")
    private Integer identificationResult;

    /** 工人id */
    @Excel(name = "工人id")
    private Integer peopleId;

    public void setIdentificationId(Integer identificationId) 
    {
        this.identificationId = identificationId;
    }

    public Integer getIdentificationId() 
    {
        return identificationId;
    }
    public void setDataId(Integer dataId) 
    {
        this.dataId = dataId;
    }

    public Integer getDataId() 
    {
        return dataId;
    }
    public void setIdentificationTime(Date identificationTime) 
    {
        this.identificationTime = identificationTime;
    }

    public Date getIdentificationTime() 
    {
        return identificationTime;
    }
    public void setIdentificationResult(Integer identificationResult) 
    {
        this.identificationResult = identificationResult;
    }

    public Integer getIdentificationResult() 
    {
        return identificationResult;
    }
    public void setPeopleId(Integer peopleId) 
    {
        this.peopleId = peopleId;
    }

    public Integer getPeopleId() 
    {
        return peopleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("identificationId", getIdentificationId())
            .append("dataId", getDataId())
            .append("identificationTime", getIdentificationTime())
            .append("identificationResult", getIdentificationResult())
            .append("peopleId", getPeopleId())
            .append("remark", getRemark())
            .toString();
    }
}
