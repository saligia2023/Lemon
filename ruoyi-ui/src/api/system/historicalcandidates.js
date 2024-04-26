import request from '@/utils/request'

// 查询历史人才库列表
export function listHistoricalcandidates(query) {
  return request({
    url: '/system/historicalcandidates/list',
    method: 'get',
    params: query
  })
}

// 查询历史人才库详细
export function getHistoricalcandidates(id) {
  return request({
    url: '/system/historicalcandidates/' + id,
    method: 'get'
  })
}

// 新增历史人才库
export function addHistoricalcandidates(data) {
  return request({
    url: '/system/historicalcandidates',
    method: 'post',
    data: data
  })
}

// 修改历史人才库
export function updateHistoricalcandidates(data) {
  return request({
    url: '/system/historicalcandidates',
    method: 'put',
    data: data
  })
}

// 删除历史人才库
export function delHistoricalcandidates(id) {
  return request({
    url: '/system/historicalcandidates/' + id,
    method: 'delete'
  })
}
