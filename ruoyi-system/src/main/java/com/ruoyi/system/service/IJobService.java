package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Job;

/**
 * 岗位管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
public interface IJobService 
{
    /**
     * 查询岗位管理
     * 
     * @param ID 岗位管理主键
     * @return 岗位管理
     */
    public Job selectJobByID(Long ID);

    /**
     * 查询岗位管理列表
     * 
     * @param job 岗位管理
     * @return 岗位管理集合
     */
    public List<Job> selectJobList(Job job);

    /**
     * 新增岗位管理
     * 
     * @param job 岗位管理
     * @return 结果
     */
    public int insertJob(Job job);

    /**
     * 修改岗位管理
     * 
     * @param job 岗位管理
     * @return 结果
     */
    public int updateJob(Job job);

    /**
     * 批量删除岗位管理
     * 
     * @param IDs 需要删除的岗位管理主键集合
     * @return 结果
     */
    public int deleteJobByIDs(Long[] IDs);

    /**
     * 删除岗位管理信息
     * 
     * @param ID 岗位管理主键
     * @return 结果
     */
    public int deleteJobByID(Long ID);
}
