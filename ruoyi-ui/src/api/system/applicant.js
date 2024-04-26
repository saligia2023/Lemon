import request from '@/utils/request'

// 查询招聘管理列表
export function listApplicant(query) {
  return request({
    url: '/system/applicant/list',
    method: 'get',
    params: query
  })
}

// 查询招聘管理详细
export function getApplicant(userId) {
  return request({
    url: '/system/applicant/' + userId,
    method: 'get'
  })
}

// 新增招聘管理
export function addApplicant(data) {
  return request({
    url: '/system/applicant',
    method: 'post',
    data: data
  })
}

// 修改招聘管理
export function updateApplicant(data) {
  return request({
    url: '/system/applicant',
    method: 'put',
    data: data
  })
}

// 删除招聘管理
export function delApplicant(userId) {
  return request({
    url: '/system/applicant/' + userId,
    method: 'delete'
  })
}
