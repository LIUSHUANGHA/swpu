package com.swpu.assessmentAndAlerting.service;

import java.util.List;
import com.swpu.assessmentAndAlerting.domain.Alrmconfiguration;

/**
 * 告警配置管理Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IAlrmconfigurationService 
{
    /**
     * 查询告警配置管理
     * 
     * @param alarmId 告警配置管理主键
     * @return 告警配置管理
     */
    public Alrmconfiguration selectAlrmconfigurationByAlarmId(Long alarmId);

    /**
     * 查询告警配置管理列表
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 告警配置管理集合
     */
    public List<Alrmconfiguration> selectAlrmconfigurationList(Alrmconfiguration alrmconfiguration);

    /**
     * 新增告警配置管理
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 结果
     */
    public int insertAlrmconfiguration(Alrmconfiguration alrmconfiguration);

    /**
     * 修改告警配置管理
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 结果
     */
    public int updateAlrmconfiguration(Alrmconfiguration alrmconfiguration);

    /**
     * 批量删除告警配置管理
     * 
     * @param alarmIds 需要删除的告警配置管理主键集合
     * @return 结果
     */
    public int deleteAlrmconfigurationByAlarmIds(Long[] alarmIds);

    /**
     * 删除告警配置管理信息
     * 
     * @param alarmId 告警配置管理主键
     * @return 结果
     */
    public int deleteAlrmconfigurationByAlarmId(Long alarmId);
}
