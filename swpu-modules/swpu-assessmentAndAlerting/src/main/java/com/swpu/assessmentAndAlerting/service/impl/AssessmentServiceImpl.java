package com.swpu.assessmentAndAlerting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.assessmentAndAlerting.mapper.AssessmentMapper;
import com.swpu.assessmentAndAlerting.domain.Assessment;
import com.swpu.assessmentAndAlerting.service.IAssessmentService;

/**
 * 风险评估Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class AssessmentServiceImpl implements IAssessmentService 
{
    @Autowired
    private AssessmentMapper assessmentMapper;

    /**
     * 查询风险评估
     * 
     * @param assessmentId 风险评估主键
     * @return 风险评估
     */
    @Override
    public Assessment selectAssessmentByAssessmentId(Integer assessmentId)
    {
        return assessmentMapper.selectAssessmentByAssessmentId(assessmentId);
    }

    /**
     * 查询风险评估列表
     * 
     * @param assessment 风险评估
     * @return 风险评估
     */
    @Override
    public List<Assessment> selectAssessmentList(Assessment assessment)
    {
        return assessmentMapper.selectAssessmentList(assessment);
    }

    /**
     * 新增风险评估
     * 
     * @param assessment 风险评估
     * @return 结果
     */
    @Override
    public int insertAssessment(Assessment assessment)
    {
        return assessmentMapper.insertAssessment(assessment);
    }

    /**
     * 修改风险评估
     * 
     * @param assessment 风险评估
     * @return 结果
     */
    @Override
    public int updateAssessment(Assessment assessment)
    {
        return assessmentMapper.updateAssessment(assessment);
    }

    /**
     * 批量删除风险评估
     * 
     * @param assessmentIds 需要删除的风险评估主键
     * @return 结果
     */
    @Override
    public int deleteAssessmentByAssessmentIds(Integer[] assessmentIds)
    {
        return assessmentMapper.deleteAssessmentByAssessmentIds(assessmentIds);
    }

    /**
     * 删除风险评估信息
     * 
     * @param assessmentId 风险评估主键
     * @return 结果
     */
    @Override
    public int deleteAssessmentByAssessmentId(Integer assessmentId)
    {
        return assessmentMapper.deleteAssessmentByAssessmentId(assessmentId);
    }
}
