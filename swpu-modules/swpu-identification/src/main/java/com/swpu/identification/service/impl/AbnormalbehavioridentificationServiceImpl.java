package com.swpu.identification.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.identification.mapper.AbnormalbehavioridentificationMapper;
import com.swpu.identification.domain.Abnormalbehavioridentification;
import com.swpu.identification.service.IAbnormalbehavioridentificationService;

/**
 * 异常行为识别Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class AbnormalbehavioridentificationServiceImpl implements IAbnormalbehavioridentificationService 
{
    @Autowired
    private AbnormalbehavioridentificationMapper abnormalbehavioridentificationMapper;

    /**
     * 查询异常行为识别
     * 
     * @param identificationId 异常行为识别主键
     * @return 异常行为识别
     */
    @Override
    public Abnormalbehavioridentification selectAbnormalbehavioridentificationByIdentificationId(Integer identificationId)
    {
        return abnormalbehavioridentificationMapper.selectAbnormalbehavioridentificationByIdentificationId(identificationId);
    }

    /**
     * 查询异常行为识别列表
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 异常行为识别
     */
    @Override
    public List<Abnormalbehavioridentification> selectAbnormalbehavioridentificationList(Abnormalbehavioridentification abnormalbehavioridentification)
    {
        return abnormalbehavioridentificationMapper.selectAbnormalbehavioridentificationList(abnormalbehavioridentification);
    }

    /**
     * 新增异常行为识别
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 结果
     */
    @Override
    public int insertAbnormalbehavioridentification(Abnormalbehavioridentification abnormalbehavioridentification)
    {
        return abnormalbehavioridentificationMapper.insertAbnormalbehavioridentification(abnormalbehavioridentification);
    }

    /**
     * 修改异常行为识别
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 结果
     */
    @Override
    public int updateAbnormalbehavioridentification(Abnormalbehavioridentification abnormalbehavioridentification)
    {
        return abnormalbehavioridentificationMapper.updateAbnormalbehavioridentification(abnormalbehavioridentification);
    }

    /**
     * 批量删除异常行为识别
     * 
     * @param identificationIds 需要删除的异常行为识别主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalbehavioridentificationByIdentificationIds(Integer[] identificationIds)
    {
        return abnormalbehavioridentificationMapper.deleteAbnormalbehavioridentificationByIdentificationIds(identificationIds);
    }

    /**
     * 删除异常行为识别信息
     * 
     * @param identificationId 异常行为识别主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalbehavioridentificationByIdentificationId(Integer identificationId)
    {
        return abnormalbehavioridentificationMapper.deleteAbnormalbehavioridentificationByIdentificationId(identificationId);
    }
}
