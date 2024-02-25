package com.swpu.assessmentAndAlerting.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 通知对象 notice
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Notice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 通知id */
    private Integer noticeId;

    /** 评估id */
    @Excel(name = "评估id")
    private Integer accessmentId;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Integer acceptPeopleId;

    /** 通知时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "通知时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date noticeTime;

    public void setNoticeId(Integer noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Integer getNoticeId() 
    {
        return noticeId;
    }
    public void setAccessmentId(Integer accessmentId) 
    {
        this.accessmentId = accessmentId;
    }

    public Integer getAccessmentId() 
    {
        return accessmentId;
    }
    public void setAcceptPeopleId(Integer acceptPeopleId) 
    {
        this.acceptPeopleId = acceptPeopleId;
    }

    public Integer getAcceptPeopleId() 
    {
        return acceptPeopleId;
    }
    public void setNoticeTime(Date noticeTime) 
    {
        this.noticeTime = noticeTime;
    }

    public Date getNoticeTime() 
    {
        return noticeTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("accessmentId", getAccessmentId())
            .append("acceptPeopleId", getAcceptPeopleId())
            .append("noticeTime", getNoticeTime())
            .append("remark", getRemark())
            .toString();
    }
}
