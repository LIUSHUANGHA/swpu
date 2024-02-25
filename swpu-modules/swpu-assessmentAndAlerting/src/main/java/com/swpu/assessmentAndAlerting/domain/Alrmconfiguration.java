package com.swpu.assessmentAndAlerting.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.swpu.common.core.annotation.Excel;
import com.swpu.common.core.web.domain.BaseEntity;

/**
 * 告警配置管理对象 alrmconfiguration
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public class Alrmconfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 告警id */
    private Long alarmId;

    /** 告警级别 */
    @Excel(name = "告警级别")
    private Long alrmLevel;

    /** 触发条件 */
    @Excel(name = "触发条件")
    private String triggerConditions;

    public void setAlarmId(Long alarmId) 
    {
        this.alarmId = alarmId;
    }

    public Long getAlarmId() 
    {
        return alarmId;
    }
    public void setAlrmLevel(Long alrmLevel) 
    {
        this.alrmLevel = alrmLevel;
    }

    public Long getAlrmLevel() 
    {
        return alrmLevel;
    }
    public void setTriggerConditions(String triggerConditions) 
    {
        this.triggerConditions = triggerConditions;
    }

    public String getTriggerConditions() 
    {
        return triggerConditions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("alarmId", getAlarmId())
            .append("alrmLevel", getAlrmLevel())
            .append("triggerConditions", getTriggerConditions())
            .append("remark", getRemark())
            .toString();
    }
}
