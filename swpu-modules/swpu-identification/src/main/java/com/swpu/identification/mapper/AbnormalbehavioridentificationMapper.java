package com.swpu.identification.mapper;

import java.util.List;
import com.swpu.identification.domain.Abnormalbehavioridentification;

/**
 * 异常行为识别Mapper接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface AbnormalbehavioridentificationMapper 
{
    /**
     * 查询异常行为识别
     * 
     * @param identificationId 异常行为识别主键
     * @return 异常行为识别
     */
    public Abnormalbehavioridentification selectAbnormalbehavioridentificationByIdentificationId(Integer identificationId);

    /**
     * 查询异常行为识别列表
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 异常行为识别集合
     */
    public List<Abnormalbehavioridentification> selectAbnormalbehavioridentificationList(Abnormalbehavioridentification abnormalbehavioridentification);

    /**
     * 新增异常行为识别
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 结果
     */
    public int insertAbnormalbehavioridentification(Abnormalbehavioridentification abnormalbehavioridentification);

    /**
     * 修改异常行为识别
     * 
     * @param abnormalbehavioridentification 异常行为识别
     * @return 结果
     */
    public int updateAbnormalbehavioridentification(Abnormalbehavioridentification abnormalbehavioridentification);

    /**
     * 删除异常行为识别
     * 
     * @param identificationId 异常行为识别主键
     * @return 结果
     */
    public int deleteAbnormalbehavioridentificationByIdentificationId(Integer identificationId);

    /**
     * 批量删除异常行为识别
     * 
     * @param identificationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAbnormalbehavioridentificationByIdentificationIds(Integer[] identificationIds);
}
