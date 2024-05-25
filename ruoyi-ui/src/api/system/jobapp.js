import request from '@/utils/request'

// 查询招聘信息列表
export function listJobapp(query) {
  return request({
    url: '/system/jobapp/list',
    method: 'get',
    params: query
  })
}

// 查询招聘信息详细
export function getJobapp(id) {
  return request({
    url: '/system/jobapp/' + id,
    method: 'get'
  })
}

// 新增招聘信息
export function addJobapp(data) {
  return request({
    url: '/system/jobapp',
    method: 'post',
    data: data
  })
}

// 修改招聘信息
export function updateJobapp(data) {
  return request({
    url: '/system/jobapp',
    method: 'put',
    data: data
  })
}

// 删除招聘信息
export function delJobapp(id) {
  return request({
    url: '/system/jobapp/' + id,
    method: 'delete'
  })
}
