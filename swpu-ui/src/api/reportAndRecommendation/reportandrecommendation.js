import request from '@/utils/request'

// 查询行为分析报告和改进建议列表
export function listReportandrecommendation(query) {
  return request({
    url: '/reportAndRecommendation/reportandrecommendation/list',
    method: 'get',
    params: query
  })
}

// 查询行为分析报告和改进建议详细
export function getReportandrecommendation(studentId) {
  return request({
    url: '/reportAndRecommendation/reportandrecommendation/' + studentId,
    method: 'get'
  })
}

// 新增行为分析报告和改进建议
export function addReportandrecommendation(data) {
  return request({
    url: '/reportAndRecommendation/reportandrecommendation',
    method: 'post',
    data: data
  })
}

// 修改行为分析报告和改进建议
export function updateReportandrecommendation(data) {
  return request({
    url: '/reportAndRecommendation/reportandrecommendation',
    method: 'put',
    data: data
  })
}

// 删除行为分析报告和改进建议
export function delReportandrecommendation(studentId) {
  return request({
    url: '/reportAndRecommendation/reportandrecommendation/' + studentId,
    method: 'delete'
  })
}
