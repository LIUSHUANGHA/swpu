package com.swpu.identification.mapper;

import java.util.List;
import com.swpu.identification.domain.Identification;

/**
 * 工人异常行为识别Mapper接口
 * 
 * @author liushuang
 * @date 2024-02-01
 */
public interface IdentificationMapper 
{
    /**
     * 查询工人异常行为识别
     * 
     * @param studentId 工人异常行为识别主键
     * @return 工人异常行为识别
     */
    public Identification selectIdentificationByStudentId(Long studentId);

    /**
     * 查询工人异常行为识别列表
     * 
     * @param identification 工人异常行为识别
     * @return 工人异常行为识别集合
     */
    public List<Identification> selectIdentificationList(Identification identification);

    /**
     * 新增工人异常行为识别
     * 
     * @param identification 工人异常行为识别
     * @return 结果
     */
    public int insertIdentification(Identification identification);

    /**
     * 修改工人异常行为识别
     * 
     * @param identification 工人异常行为识别
     * @return 结果
     */
    public int updateIdentification(Identification identification);

    /**
     * 删除工人异常行为识别
     * 
     * @param studentId 工人异常行为识别主键
     * @return 结果
     */
    public int deleteIdentificationByStudentId(Long studentId);

    /**
     * 批量删除工人异常行为识别
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIdentificationByStudentIds(Long[] studentIds);
}
