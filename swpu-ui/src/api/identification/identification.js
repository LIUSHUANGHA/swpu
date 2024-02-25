import request from '@/utils/request'

// 查询工人异常行为识别列表
export function listIdentification(query) {
  return request({
    url: '/identification/identification/list',
    method: 'get',
    params: query
  })
}

// 查询工人异常行为识别详细
export function getIdentification(studentId) {
  return request({
    url: '/identification/identification/' + studentId,
    method: 'get'
  })
}

// 新增工人异常行为识别
export function addIdentification(data) {
  return request({
    url: '/identification/identification',
    method: 'post',
    data: data
  })
}

// 修改工人异常行为识别
export function updateIdentification(data) {
  return request({
    url: '/identification/identification',
    method: 'put',
    data: data
  })
}

// 删除工人异常行为识别
export function delIdentification(studentId) {
  return request({
    url: '/identification/identification/' + studentId,
    method: 'delete'
  })
}
