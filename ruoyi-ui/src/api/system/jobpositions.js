import request from '@/utils/request'

// 查询职位管理列表
export function listJobpositions(query) {
  return request({
    url: '/system/jobpositions/list',
    method: 'get',
    params: query
  })
}

// 查询职位管理详细
export function getJobpositions(id) {
  return request({
    url: '/system/jobpositions/' + id,
    method: 'get'
  })
}

// 新增职位管理
export function addJobpositions(data) {
  return request({
    url: '/system/jobpositions',
    method: 'post',
    data: data
  })
}

// 修改职位管理
export function updateJobpositions(data) {
  return request({
    url: '/system/jobpositions',
    method: 'put',
    data: data
  })
}

// 删除职位管理
export function delJobpositions(id) {
  return request({
    url: '/system/jobpositions/' + id,
    method: 'delete'
  })
}
