package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JobpositionsMapper;
import com.ruoyi.system.domain.Jobpositions;
import com.ruoyi.system.service.IJobpositionsService;

/**
 * 职位管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
@Service
public class JobpositionsServiceImpl implements IJobpositionsService 
{
    @Autowired
    private JobpositionsMapper jobpositionsMapper;

    /**
     * 查询职位管理
     * 
     * @param id 职位管理主键
     * @return 职位管理
     */
    @Override
    public Jobpositions selectJobpositionsById(Long id)
    {
        return jobpositionsMapper.selectJobpositionsById(id);
    }

    /**
     * 查询职位管理列表
     * 
     * @param jobpositions 职位管理
     * @return 职位管理
     */
    @Override
    public List<Jobpositions> selectJobpositionsList(Jobpositions jobpositions)
    {
        return jobpositionsMapper.selectJobpositionsList(jobpositions);
    }

    /**
     * 新增职位管理
     * 
     * @param jobpositions 职位管理
     * @return 结果
     */
    @Override
    public int insertJobpositions(Jobpositions jobpositions)
    {
        return jobpositionsMapper.insertJobpositions(jobpositions);
    }

    /**
     * 修改职位管理
     * 
     * @param jobpositions 职位管理
     * @return 结果
     */
    @Override
    public int updateJobpositions(Jobpositions jobpositions)
    {
        return jobpositionsMapper.updateJobpositions(jobpositions);
    }

    /**
     * 批量删除职位管理
     * 
     * @param ids 需要删除的职位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobpositionsByIds(Long[] ids)
    {
        return jobpositionsMapper.deleteJobpositionsByIds(ids);
    }

    /**
     * 删除职位管理信息
     * 
     * @param id 职位管理主键
     * @return 结果
     */
    @Override
    public int deleteJobpositionsById(Long id)
    {
        return jobpositionsMapper.deleteJobpositionsById(id);
    }
}
