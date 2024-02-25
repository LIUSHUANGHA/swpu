package com.swpu.identification.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 异常行为识别对象 abnormalbehavioridentification
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Abnormalbehavioridentification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 识别id */
    private Integer identificationId;

    /** 数据id */
    @Excel(name = "数据id")
    private Integer dataId;

    /** 识别进程 */
    @Excel(name = "识别进程")
    private Integer identificationProcess;

    /** 管理员判定工人id进程 */
    @Excel(name = "管理员判定工人id进程")
    private Integer peopleProcess;

    /** 识别时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "识别时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date identificationTime;

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
    public void setIdentificationProcess(Integer identificationProcess) 
    {
        this.identificationProcess = identificationProcess;
    }

    public Integer getIdentificationProcess() 
    {
        return identificationProcess;
    }
    public void setPeopleProcess(Integer peopleProcess) 
    {
        this.peopleProcess = peopleProcess;
    }

    public Integer getPeopleProcess() 
    {
        return peopleProcess;
    }
    public void setIdentificationTime(Date identificationTime) 
    {
        this.identificationTime = identificationTime;
    }

    public Date getIdentificationTime() 
    {
        return identificationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("identificationId", getIdentificationId())
            .append("dataId", getDataId())
            .append("identificationProcess", getIdentificationProcess())
            .append("peopleProcess", getPeopleProcess())
            .append("identificationTime", getIdentificationTime())
            .append("remark", getRemark())
            .toString();
    }
}
