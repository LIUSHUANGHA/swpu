import request from '@/utils/request'

// 查询行为数据分析列表
export function listAnalysis(query) {
  return request({
    url: '/reportAndRecommendation/analysis/list',
    method: 'get',
    params: query
  })
}

// 查询行为数据分析详细
export function getAnalysis(analysisId) {
  return request({
    url: '/reportAndRecommendation/analysis/' + analysisId,
    method: 'get'
  })
}

// 新增行为数据分析
export function addAnalysis(data) {
  return request({
    url: '/reportAndRecommendation/analysis',
    method: 'post',
    data: data
  })
}

// 修改行为数据分析
export function updateAnalysis(data) {
  return request({
    url: '/reportAndRecommendation/analysis',
    method: 'put',
    data: data
  })
}

// 删除行为数据分析
export function delAnalysis(analysisId) {
  return request({
    url: '/reportAndRecommendation/analysis/' + analysisId,
    method: 'delete'
  })
}
