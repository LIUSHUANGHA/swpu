package com.swpu.assessmentAndAlerting.mapper;

import java.util.List;
import com.swpu.assessmentAndAlerting.domain.Assessmentandalerting;

/**
 * 风险评估和告警Mapper接口
 * 
 * @author liushuang
 * @date 2024-02-01
 */
public interface AssessmentandalertingMapper 
{
    /**
     * 查询风险评估和告警
     * 
     * @param studentId 风险评估和告警主键
     * @return 风险评估和告警
     */
    public Assessmentandalerting selectAssessmentandalertingByStudentId(Long studentId);

    /**
     * 查询风险评估和告警列表
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 风险评估和告警集合
     */
    public List<Assessmentandalerting> selectAssessmentandalertingList(Assessmentandalerting assessmentandalerting);

    /**
     * 新增风险评估和告警
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 结果
     */
    public int insertAssessmentandalerting(Assessmentandalerting assessmentandalerting);

    /**
     * 修改风险评估和告警
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 结果
     */
    public int updateAssessmentandalerting(Assessmentandalerting assessmentandalerting);

    /**
     * 删除风险评估和告警
     * 
     * @param studentId 风险评估和告警主键
     * @return 结果
     */
    public int deleteAssessmentandalertingByStudentId(Long studentId);

    /**
     * 批量删除风险评估和告警
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssessmentandalertingByStudentIds(Long[] studentIds);
}
