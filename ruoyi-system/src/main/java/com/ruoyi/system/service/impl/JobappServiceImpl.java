package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JobappMapper;
import com.ruoyi.system.domain.Jobapp;
import com.ruoyi.system.service.IJobappService;

/**
 * 招聘信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-17
 */
@Service
public class JobappServiceImpl implements IJobappService 
{
    @Autowired
    private JobappMapper jobappMapper;

    /**
     * 查询招聘信息
     * 
     * @param id 招聘信息主键
     * @return 招聘信息
     */
    @Override
    public Jobapp selectJobappById(Long id)
    {
        return jobappMapper.selectJobappById(id);
    }

    /**
     * 查询招聘信息列表
     * 
     * @param jobapp 招聘信息
     * @return 招聘信息
     */
    @Override
    public List<Jobapp> selectJobappList(Jobapp jobapp)
    {
        return jobappMapper.selectJobappList(jobapp);
    }

    /**
     * 新增招聘信息
     * 
     * @param jobapp 招聘信息
     * @return 结果
     */
    @Override
    public int insertJobapp(Jobapp jobapp)
    {
        return jobappMapper.insertJobapp(jobapp);
    }

    /**
     * 修改招聘信息
     * 
     * @param jobapp 招聘信息
     * @return 结果
     */
    @Override
    public int updateJobapp(Jobapp jobapp)
    {
        return jobappMapper.updateJobapp(jobapp);
    }

    /**
     * 批量删除招聘信息
     * 
     * @param ids 需要删除的招聘信息主键
     * @return 结果
     */
    @Override
    public int deleteJobappByIds(Long[] ids)
    {
        return jobappMapper.deleteJobappByIds(ids);
    }

    /**
     * 删除招聘信息信息
     * 
     * @param id 招聘信息主键
     * @return 结果
     */
    @Override
    public int deleteJobappById(Long id)
    {
        return jobappMapper.deleteJobappById(id);
    }
}
