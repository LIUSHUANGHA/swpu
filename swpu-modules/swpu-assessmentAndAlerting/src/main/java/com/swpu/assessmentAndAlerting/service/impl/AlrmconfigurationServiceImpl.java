package com.swpu.assessmentAndAlerting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.assessmentAndAlerting.mapper.AlrmconfigurationMapper;
import com.swpu.assessmentAndAlerting.domain.Alrmconfiguration;
import com.swpu.assessmentAndAlerting.service.IAlrmconfigurationService;

/**
 * 告警配置管理Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class AlrmconfigurationServiceImpl implements IAlrmconfigurationService 
{
    @Autowired
    private AlrmconfigurationMapper alrmconfigurationMapper;

    /**
     * 查询告警配置管理
     * 
     * @param alarmId 告警配置管理主键
     * @return 告警配置管理
     */
    @Override
    public Alrmconfiguration selectAlrmconfigurationByAlarmId(Long alarmId)
    {
        return alrmconfigurationMapper.selectAlrmconfigurationByAlarmId(alarmId);
    }

    /**
     * 查询告警配置管理列表
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 告警配置管理
     */
    @Override
    public List<Alrmconfiguration> selectAlrmconfigurationList(Alrmconfiguration alrmconfiguration)
    {
        return alrmconfigurationMapper.selectAlrmconfigurationList(alrmconfiguration);
    }

    /**
     * 新增告警配置管理
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 结果
     */
    @Override
    public int insertAlrmconfiguration(Alrmconfiguration alrmconfiguration)
    {
        return alrmconfigurationMapper.insertAlrmconfiguration(alrmconfiguration);
    }

    /**
     * 修改告警配置管理
     * 
     * @param alrmconfiguration 告警配置管理
     * @return 结果
     */
    @Override
    public int updateAlrmconfiguration(Alrmconfiguration alrmconfiguration)
    {
        return alrmconfigurationMapper.updateAlrmconfiguration(alrmconfiguration);
    }

    /**
     * 批量删除告警配置管理
     * 
     * @param alarmIds 需要删除的告警配置管理主键
     * @return 结果
     */
    @Override
    public int deleteAlrmconfigurationByAlarmIds(Long[] alarmIds)
    {
        return alrmconfigurationMapper.deleteAlrmconfigurationByAlarmIds(alarmIds);
    }

    /**
     * 删除告警配置管理信息
     * 
     * @param alarmId 告警配置管理主键
     * @return 结果
     */
    @Override
    public int deleteAlrmconfigurationByAlarmId(Long alarmId)
    {
        return alrmconfigurationMapper.deleteAlrmconfigurationByAlarmId(alarmId);
    }
}
