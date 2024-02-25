import request from '@/utils/request'

// 查询报告生成列表
export function listReport(query) {
  return request({
    url: '/reportAndRecommendation/report/list',
    method: 'get',
    params: query
  })
}

// 查询报告生成详细
export function getReport(reportid) {
  return request({
    url: '/reportAndRecommendation/report/' + reportid,
    method: 'get'
  })
}

// 新增报告生成
export function addReport(data) {
  return request({
    url: '/reportAndRecommendation/report',
    method: 'post',
    data: data
  })
}

// 修改报告生成
export function updateReport(data) {
  return request({
    url: '/reportAndRecommendation/report',
    method: 'put',
    data: data
  })
}

// 删除报告生成
export function delReport(reportid) {
  return request({
    url: '/reportAndRecommendation/report/' + reportid,
    method: 'delete'
  })
}
