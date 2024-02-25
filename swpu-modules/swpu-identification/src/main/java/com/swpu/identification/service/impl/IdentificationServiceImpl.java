package com.swpu.identification.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.identification.mapper.IdentificationMapper;
import com.swpu.identification.domain.Identification;
import com.swpu.identification.service.IIdentificationService;

/**
 * 工人异常行为识别Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@Service
public class IdentificationServiceImpl implements IIdentificationService 
{
    @Autowired
    private IdentificationMapper identificationMapper;

    /**
     * 查询工人异常行为识别
     * 
     * @param studentId 工人异常行为识别主键
     * @return 工人异常行为识别
     */
    @Override
    public Identification selectIdentificationByStudentId(Long studentId)
    {
        return identificationMapper.selectIdentificationByStudentId(studentId);
    }

    /**
     * 查询工人异常行为识别列表
     * 
     * @param identification 工人异常行为识别
     * @return 工人异常行为识别
     */
    @Override
    public List<Identification> selectIdentificationList(Identification identification)
    {
        return identificationMapper.selectIdentificationList(identification);
    }

    /**
     * 新增工人异常行为识别
     * 
     * @param identification 工人异常行为识别
     * @return 结果
     */
    @Override
    public int insertIdentification(Identification identification)
    {
        return identificationMapper.insertIdentification(identification);
    }

    /**
     * 修改工人异常行为识别
     * 
     * @param identification 工人异常行为识别
     * @return 结果
     */
    @Override
    public int updateIdentification(Identification identification)
    {
        return identificationMapper.updateIdentification(identification);
    }

    /**
     * 批量删除工人异常行为识别
     * 
     * @param studentIds 需要删除的工人异常行为识别主键
     * @return 结果
     */
    @Override
    public int deleteIdentificationByStudentIds(Long[] studentIds)
    {
        return identificationMapper.deleteIdentificationByStudentIds(studentIds);
    }

    /**
     * 删除工人异常行为识别信息
     * 
     * @param studentId 工人异常行为识别主键
     * @return 结果
     */
    @Override
    public int deleteIdentificationByStudentId(Long studentId)
    {
        return identificationMapper.deleteIdentificationByStudentId(studentId);
    }
}
