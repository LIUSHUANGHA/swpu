import request from '@/utils/request'

// 查询摄像头接入列表
export function listCameraaccess(query) {
  return request({
    url: '/identification/cameraaccess/list',
    method: 'get',
    params: query
  })
}

// 查询摄像头接入详细
export function getCameraaccess(cameraId) {
  return request({
    url: '/identification/cameraaccess/' + cameraId,
    method: 'get'
  })
}

// 新增摄像头接入
export function addCameraaccess(data) {
  return request({
    url: '/identification/cameraaccess',
    method: 'post',
    data: data
  })
}

// 修改摄像头接入
export function updateCameraaccess(data) {
  return request({
    url: '/identification/cameraaccess',
    method: 'put',
    data: data
  })
}

// 删除摄像头接入
export function delCameraaccess(cameraId) {
  return request({
    url: '/identification/cameraaccess/' + cameraId,
    method: 'delete'
  })
}
