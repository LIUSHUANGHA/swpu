package com.swpu.assessmentAndAlerting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.assessmentAndAlerting.mapper.AssessmentandalertingMapper;
import com.swpu.assessmentAndAlerting.domain.Assessmentandalerting;
import com.swpu.assessmentAndAlerting.service.IAssessmentandalertingService;

/**
 * 风险评估和告警Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-01
 */
@Service
public class AssessmentandalertingServiceImpl implements IAssessmentandalertingService 
{
    @Autowired
    private AssessmentandalertingMapper assessmentandalertingMapper;

    /**
     * 查询风险评估和告警
     * 
     * @param studentId 风险评估和告警主键
     * @return 风险评估和告警
     */
    @Override
    public Assessmentandalerting selectAssessmentandalertingByStudentId(Long studentId)
    {
        return assessmentandalertingMapper.selectAssessmentandalertingByStudentId(studentId);
    }

    /**
     * 查询风险评估和告警列表
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 风险评估和告警
     */
    @Override
    public List<Assessmentandalerting> selectAssessmentandalertingList(Assessmentandalerting assessmentandalerting)
    {
        return assessmentandalertingMapper.selectAssessmentandalertingList(assessmentandalerting);
    }

    /**
     * 新增风险评估和告警
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 结果
     */
    @Override
    public int insertAssessmentandalerting(Assessmentandalerting assessmentandalerting)
    {
        return assessmentandalertingMapper.insertAssessmentandalerting(assessmentandalerting);
    }

    /**
     * 修改风险评估和告警
     * 
     * @param assessmentandalerting 风险评估和告警
     * @return 结果
     */
    @Override
    public int updateAssessmentandalerting(Assessmentandalerting assessmentandalerting)
    {
        return assessmentandalertingMapper.updateAssessmentandalerting(assessmentandalerting);
    }

    /**
     * 批量删除风险评估和告警
     * 
     * @param studentIds 需要删除的风险评估和告警主键
     * @return 结果
     */
    @Override
    public int deleteAssessmentandalertingByStudentIds(Long[] studentIds)
    {
        return assessmentandalertingMapper.deleteAssessmentandalertingByStudentIds(studentIds);
    }

    /**
     * 删除风险评估和告警信息
     * 
     * @param studentId 风险评估和告警主键
     * @return 结果
     */
    @Override
    public int deleteAssessmentandalertingByStudentId(Long studentId)
    {
        return assessmentandalertingMapper.deleteAssessmentandalertingByStudentId(studentId);
    }
}
