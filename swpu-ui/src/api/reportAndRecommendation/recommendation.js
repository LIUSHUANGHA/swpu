import request from '@/utils/request'

// 查询改进建议列表
export function listRecommendation(query) {
  return request({
    url: '/reportAndRecommendation/recommendation/list',
    method: 'get',
    params: query
  })
}

// 查询改进建议详细
export function getRecommendation(recommendationId) {
  return request({
    url: '/reportAndRecommendation/recommendation/' + recommendationId,
    method: 'get'
  })
}

// 新增改进建议
export function addRecommendation(data) {
  return request({
    url: '/reportAndRecommendation/recommendation',
    method: 'post',
    data: data
  })
}

// 修改改进建议
export function updateRecommendation(data) {
  return request({
    url: '/reportAndRecommendation/recommendation',
    method: 'put',
    data: data
  })
}

// 删除改进建议
export function delRecommendation(recommendationId) {
  return request({
    url: '/reportAndRecommendation/recommendation/' + recommendationId,
    method: 'delete'
  })
}
