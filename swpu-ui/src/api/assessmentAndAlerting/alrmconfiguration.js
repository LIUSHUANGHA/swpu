import request from '@/utils/request'

// 查询告警配置管理列表
export function listAlrmconfiguration(query) {
  return request({
    url: '/assessmentAndAlerting/alrmconfiguration/list',
    method: 'get',
    params: query
  })
}

// 查询告警配置管理详细
export function getAlrmconfiguration(alarmId) {
  return request({
    url: '/assessmentAndAlerting/alrmconfiguration/' + alarmId,
    method: 'get'
  })
}

// 新增告警配置管理
export function addAlrmconfiguration(data) {
  return request({
    url: '/assessmentAndAlerting/alrmconfiguration',
    method: 'post',
    data: data
  })
}

// 修改告警配置管理
export function updateAlrmconfiguration(data) {
  return request({
    url: '/assessmentAndAlerting/alrmconfiguration',
    method: 'put',
    data: data
  })
}

// 删除告警配置管理
export function delAlrmconfiguration(alarmId) {
  return request({
    url: '/assessmentAndAlerting/alrmconfiguration/' + alarmId,
    method: 'delete'
  })
}
