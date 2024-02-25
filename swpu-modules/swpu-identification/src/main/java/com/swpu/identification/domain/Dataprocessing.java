package com.swpu.identification.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 数据处理对象 dataprocessing
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Dataprocessing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据id */
    private Integer dataId;

    /** 摄像头id */
    @Excel(name = "摄像头id")
    private Integer cameraId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer processingStatus;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String processingResult;

    public void setDataId(Integer dataId) 
    {
        this.dataId = dataId;
    }

    public Integer getDataId() 
    {
        return dataId;
    }
    public void setCameraId(Integer cameraId) 
    {
        this.cameraId = cameraId;
    }

    public Integer getCameraId() 
    {
        return cameraId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setProcessingStatus(Integer processingStatus) 
    {
        this.processingStatus = processingStatus;
    }

    public Integer getProcessingStatus() 
    {
        return processingStatus;
    }
    public void setProcessingResult(String processingResult) 
    {
        this.processingResult = processingResult;
    }

    public String getProcessingResult() 
    {
        return processingResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dataId", getDataId())
            .append("cameraId", getCameraId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("processingStatus", getProcessingStatus())
            .append("processingResult", getProcessingResult())
            .append("remark", getRemark())
            .toString();
    }
}
