import request from '@/utils/request'

// 查询风险评估和告警列表
export function listAssessmentandalerting(query) {
  return request({
    url: '/assessmentAndAlerting/assessmentandalerting/list',
    method: 'get',
    params: query
  })
}

// 查询风险评估和告警详细
export function getAssessmentandalerting(studentId) {
  return request({
    url: '/assessmentAndAlerting/assessmentandalerting/' + studentId,
    method: 'get'
  })
}

// 新增风险评估和告警
export function addAssessmentandalerting(data) {
  return request({
    url: '/assessmentAndAlerting/assessmentandalerting',
    method: 'post',
    data: data
  })
}

// 修改风险评估和告警
export function updateAssessmentandalerting(data) {
  return request({
    url: '/assessmentAndAlerting/assessmentandalerting',
    method: 'put',
    data: data
  })
}

// 删除风险评估和告警
export function delAssessmentandalerting(studentId) {
  return request({
    url: '/assessmentAndAlerting/assessmentandalerting/' + studentId,
    method: 'delete'
  })
}
