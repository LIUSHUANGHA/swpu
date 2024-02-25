package com.swpu.assessmentAndAlerting.mapper;

import java.util.List;
import com.swpu.assessmentAndAlerting.domain.Assessment;

/**
 * 风险评估Mapper接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface AssessmentMapper 
{
    /**
     * 查询风险评估
     * 
     * @param assessmentId 风险评估主键
     * @return 风险评估
     */
    public Assessment selectAssessmentByAssessmentId(Integer assessmentId);

    /**
     * 查询风险评估列表
     * 
     * @param assessment 风险评估
     * @return 风险评估集合
     */
    public List<Assessment> selectAssessmentList(Assessment assessment);

    /**
     * 新增风险评估
     * 
     * @param assessment 风险评估
     * @return 结果
     */
    public int insertAssessment(Assessment assessment);

    /**
     * 修改风险评估
     * 
     * @param assessment 风险评估
     * @return 结果
     */
    public int updateAssessment(Assessment assessment);

    /**
     * 删除风险评估
     * 
     * @param assessmentId 风险评估主键
     * @return 结果
     */
    public int deleteAssessmentByAssessmentId(Integer assessmentId);

    /**
     * 批量删除风险评估
     * 
     * @param assessmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssessmentByAssessmentIds(Integer[] assessmentIds);
}
