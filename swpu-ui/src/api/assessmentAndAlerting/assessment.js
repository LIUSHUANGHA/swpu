import request from '@/utils/request'

// 查询风险评估列表
export function listAssessment(query) {
  return request({
    url: '/assessmentAndAlerting/assessment/list',
    method: 'get',
    params: query
  })
}

// 查询风险评估详细
export function getAssessment(assessmentId) {
  return request({
    url: '/assessmentAndAlerting/assessment/' + assessmentId,
    method: 'get'
  })
}

// 新增风险评估
export function addAssessment(data) {
  return request({
    url: '/assessmentAndAlerting/assessment',
    method: 'post',
    data: data
  })
}

// 修改风险评估
export function updateAssessment(data) {
  return request({
    url: '/assessmentAndAlerting/assessment',
    method: 'put',
    data: data
  })
}

// 删除风险评估
export function delAssessment(assessmentId) {
  return request({
    url: '/assessmentAndAlerting/assessment/' + assessmentId,
    method: 'delete'
  })
}
