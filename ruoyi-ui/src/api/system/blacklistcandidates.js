import request from '@/utils/request'

// 查询黑名单列表
export function listBlacklistcandidates(query) {
  return request({
    url: '/system/blacklistcandidates/list',
    method: 'get',
    params: query
  })
}

// 查询黑名单详细
export function getBlacklistcandidates(id) {
  return request({
    url: '/system/blacklistcandidates/' + id,
    method: 'get'
  })
}

// 新增黑名单
export function addBlacklistcandidates(data) {
  return request({
    url: '/system/blacklistcandidates',
    method: 'post',
    data: data
  })
}

// 修改黑名单
export function updateBlacklistcandidates(data) {
  return request({
    url: '/system/blacklistcandidates',
    method: 'put',
    data: data
  })
}

// 删除黑名单
export function delBlacklistcandidates(id) {
  return request({
    url: '/system/blacklistcandidates/' + id,
    method: 'delete'
  })
}
