import request from '@/utils/request'

// 查询数据处理列表
export function listDataprocessing(query) {
  return request({
    url: '/identification/dataprocessing/list',
    method: 'get',
    params: query
  })
}

// 查询数据处理详细
export function getDataprocessing(dataId) {
  return request({
    url: '/identification/dataprocessing/' + dataId,
    method: 'get'
  })
}

// 新增数据处理
export function addDataprocessing(data) {
  return request({
    url: '/identification/dataprocessing',
    method: 'post',
    data: data
  })
}

// 修改数据处理
export function updateDataprocessing(data) {
  return request({
    url: '/identification/dataprocessing',
    method: 'put',
    data: data
  })
}

// 删除数据处理
export function delDataprocessing(dataId) {
  return request({
    url: '/identification/dataprocessing/' + dataId,
    method: 'delete'
  })
}
