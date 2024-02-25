package com.swpu.identification.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.identification.mapper.AbnormalbehaviorshowMapper;
import com.swpu.identification.domain.Abnormalbehaviorshow;
import com.swpu.identification.service.IAbnormalbehaviorshowService;

/**
 * 异常行为展示Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class AbnormalbehaviorshowServiceImpl implements IAbnormalbehaviorshowService 
{
    @Autowired
    private AbnormalbehaviorshowMapper abnormalbehaviorshowMapper;

    /**
     * 查询异常行为展示
     * 
     * @param identificationId 异常行为展示主键
     * @return 异常行为展示
     */
    @Override
    public Abnormalbehaviorshow selectAbnormalbehaviorshowByIdentificationId(Integer identificationId)
    {
        return abnormalbehaviorshowMapper.selectAbnormalbehaviorshowByIdentificationId(identificationId);
    }

    /**
     * 查询异常行为展示列表
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 异常行为展示
     */
    @Override
    public List<Abnormalbehaviorshow> selectAbnormalbehaviorshowList(Abnormalbehaviorshow abnormalbehaviorshow)
    {
        return abnormalbehaviorshowMapper.selectAbnormalbehaviorshowList(abnormalbehaviorshow);
    }

    /**
     * 新增异常行为展示
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 结果
     */
    @Override
    public int insertAbnormalbehaviorshow(Abnormalbehaviorshow abnormalbehaviorshow)
    {
        return abnormalbehaviorshowMapper.insertAbnormalbehaviorshow(abnormalbehaviorshow);
    }

    /**
     * 修改异常行为展示
     * 
     * @param abnormalbehaviorshow 异常行为展示
     * @return 结果
     */
    @Override
    public int updateAbnormalbehaviorshow(Abnormalbehaviorshow abnormalbehaviorshow)
    {
        return abnormalbehaviorshowMapper.updateAbnormalbehaviorshow(abnormalbehaviorshow);
    }

    /**
     * 批量删除异常行为展示
     * 
     * @param identificationIds 需要删除的异常行为展示主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalbehaviorshowByIdentificationIds(Integer[] identificationIds)
    {
        return abnormalbehaviorshowMapper.deleteAbnormalbehaviorshowByIdentificationIds(identificationIds);
    }

    /**
     * 删除异常行为展示信息
     * 
     * @param identificationId 异常行为展示主键
     * @return 结果
     */
    @Override
    public int deleteAbnormalbehaviorshowByIdentificationId(Integer identificationId)
    {
        return abnormalbehaviorshowMapper.deleteAbnormalbehaviorshowByIdentificationId(identificationId);
    }
}
