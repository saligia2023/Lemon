import request from '@/utils/request'

// 查询岗位管理列表
export function listJob(query) {
  return request({
    url: '/system/job/list',
    method: 'get',
    params: query
  })
}

// 查询岗位管理详细
export function getJob(ID) {
  return request({
    url: '/system/job/' + ID,
    method: 'get'
  })
}

// 新增岗位管理
export function addJob(data) {
  return request({
    url: '/system/job',
    method: 'post',
    data: data
  })
}

// 修改岗位管理
export function updateJob(data) {
  return request({
    url: '/system/job',
    method: 'put',
    data: data
  })
}

// 删除岗位管理
export function delJob(ID) {
  return request({
    url: '/system/job/' + ID,
    method: 'delete'
  })
}
