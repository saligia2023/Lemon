import request from '@/utils/request'

// 查询应聘列表
export function listRecruit(query) {
  return request({
    url: '/system/recruit/list',
    method: 'get',
    params: query
  })
}

// 查询应聘详细
export function getRecruit(UserID) {
  return request({
    url: '/system/recruit/' + UserID,
    method: 'get'
  })
}

// 新增应聘
export function addRecruit(data) {
  return request({
    url: '/system/recruit',
    method: 'post',
    data: data
  })
}

// 修改应聘
export function updateRecruit(data) {
  return request({
    url: '/system/recruit',
    method: 'put',
    data: data
  })
}

// 删除应聘
export function delRecruit(UserID) {
  return request({
    url: '/system/recruit/' + UserID,
    method: 'delete'
  })
}
