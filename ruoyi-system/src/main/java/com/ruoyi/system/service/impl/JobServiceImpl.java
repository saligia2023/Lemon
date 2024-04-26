package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JobMapper;
import com.ruoyi.system.domain.Job;
import com.ruoyi.system.service.IJobService;

/**
 * 岗位管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
@Service
public class JobServiceImpl implements IJobService 
{
    @Autowired
    private JobMapper jobMapper;

    /**
     * 查询岗位管理
     * 
     * @param ID 岗位管理主键
     * @return 岗位管理
     */
    @Override
    public Job selectJobByID(Long ID)
    {
        return jobMapper.selectJobByID(ID);
    }

    /**
     * 查询岗位管理列表
     * 
     * @param job 岗位管理
     * @return 岗位管理
     */
    @Override
    public List<Job> selectJobList(Job job)
    {
        return jobMapper.selectJobList(job);
    }

    /**
     * 新增岗位管理
     * 
     * @param job 岗位管理
     * @return 结果
     */
    @Override
    public int insertJob(Job job)
    {
        return jobMapper.insertJob(job);
    }

    /**
     * 修改岗位管理
     * 
     * @param job 岗位管理
     * @return 结果
     */
    @Override
    public int updateJob(Job job)
    {
        return jobMapper.updateJob(job);
    }

    /**
     * 批量删除岗位管理
     * 
     * @param IDs 需要删除的岗位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobByIDs(Long[] IDs)
    {
        return jobMapper.deleteJobByIDs(IDs);
    }

    /**
     * 删除岗位管理信息
     * 
     * @param ID 岗位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobByID(Long ID)
    {
        return jobMapper.deleteJobByID(ID);
    }
}
