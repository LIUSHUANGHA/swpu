import request from '@/utils/request'

// 查询异常行为识别列表
export function listAbnormalbehavioridentification(query) {
  return request({
    url: '/identification/abnormalbehavioridentification/list',
    method: 'get',
    params: query
  })
}

// 查询异常行为识别详细
export function getAbnormalbehavioridentification(identificationId) {
  return request({
    url: '/identification/abnormalbehavioridentification/' + identificationId,
    method: 'get'
  })
}

// 新增异常行为识别
export function addAbnormalbehavioridentification(data) {
  return request({
    url: '/identification/abnormalbehavioridentification',
    method: 'post',
    data: data
  })
}

// 修改异常行为识别
export function updateAbnormalbehavioridentification(data) {
  return request({
    url: '/identification/abnormalbehavioridentification',
    method: 'put',
    data: data
  })
}

// 删除异常行为识别
export function delAbnormalbehavioridentification(identificationId) {
  return request({
    url: '/identification/abnormalbehavioridentification/' + identificationId,
    method: 'delete'
  })
}
