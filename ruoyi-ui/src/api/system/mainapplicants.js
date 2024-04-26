import request from '@/utils/request'

// 查询应聘成员列表
export function listMainapplicants(query) {
  return request({
    url: '/system/mainapplicants/list',
    method: 'get',
    params: query
  })
}

// 查询应聘成员详细
export function getMainapplicants(id) {
  return request({
    url: '/system/mainapplicants/' + id,
    method: 'get'
  })
}

// 新增应聘成员
export function addMainapplicants(data) {
  return request({
    url: '/system/mainapplicants',
    method: 'post',
    data: data
  })
}

// 修改应聘成员
export function updateMainapplicants(data) {
  return request({
    url: '/system/mainapplicants',
    method: 'put',
    data: data
  })
}

// 删除应聘成员
export function delMainapplicants(id) {
  return request({
    url: '/system/mainapplicants/' + id,
    method: 'delete'
  })
}
