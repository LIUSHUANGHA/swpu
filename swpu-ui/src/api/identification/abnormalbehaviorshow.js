import request from '@/utils/request'

// 查询异常行为展示列表
export function listAbnormalbehaviorshow(query) {
  return request({
    url: '/identification/abnormalbehaviorshow/list',
    method: 'get',
    params: query
  })
}

// 查询异常行为展示详细
export function getAbnormalbehaviorshow(identificationId) {
  return request({
    url: '/identification/abnormalbehaviorshow/' + identificationId,
    method: 'get'
  })
}

// 新增异常行为展示
export function addAbnormalbehaviorshow(data) {
  return request({
    url: '/identification/abnormalbehaviorshow',
    method: 'post',
    data: data
  })
}

// 修改异常行为展示
export function updateAbnormalbehaviorshow(data) {
  return request({
    url: '/identification/abnormalbehaviorshow',
    method: 'put',
    data: data
  })
}

// 删除异常行为展示
export function delAbnormalbehaviorshow(identificationId) {
  return request({
    url: '/identification/abnormalbehaviorshow/' + identificationId,
    method: 'delete'
  })
}
