package com.swpu.identification.service;

import java.util.List;
import com.swpu.identification.domain.Abnormalbehaviorshow;

/**
 * 异常行为展示Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IAbnormalbehaviorshowService 
{
    /**
     * 查询异常行为展示
     * 
     * @param identificationId 异常行为展示主键
     * @return 异常行为展示
     */
    public Abnormalbehaviorshow selectAbnormalbehaviorshowByIdentificationId(Integer identificationId);

    /**
     * 查询异常行为展示列表
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 异常行为展示集合
     */
    public List<Abnormalbehaviorshow> selectAbnormalbehaviorshowList(Abnormalbehaviorshow abnormalbehaviorshow);

    /**
     * 新增异常行为展示
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 结果
     */
    public int insertAbnormalbehaviorshow(Abnormalbehaviorshow abnormalbehaviorshow);

    /**
     * 修改异常行为展示
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 结果
     */
    public int updateAbnormalbehaviorshow(Abnormalbehaviorshow abnormalbehaviorshow);

    /**
     * 批量删除异常行为展示
     * 
     * @param identificationIds 需要删除的异常行为展示主键集合
     * @return 结果
     */
    public int deleteAbnormalbehaviorshowByIdentificationIds(Integer[] identificationIds);

    /**
     * 删除异常行为展示信息
     * 
     * @param identificationId 异常行为展示主键
     * @return 结果
     */
    public int deleteAbnormalbehaviorshowByIdentificationId(Integer identificationId);
}
