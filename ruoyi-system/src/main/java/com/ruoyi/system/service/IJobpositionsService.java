package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Jobpositions;

/**
 * 职位管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
public interface IJobpositionsService 
{
    /**
     * 查询职位管理
     * 
     * @param id 职位管理主键
     * @return 职位管理
     */
    public Jobpositions selectJobpositionsById(Long id);

    /**
     * 查询职位管理列表
     * 
     * @param jobpositions 职位管理
     * @return 职位管理集合
     */
    public List<Jobpositions> selectJobpositionsList(Jobpositions jobpositions);

    /**
     * 新增职位管理
     * 
     * @param jobpositions 职位管理
     * @return 结果
     */
    public int insertJobpositions(Jobpositions jobpositions);

    /**
     * 修改职位管理
     * 
     * @param jobpositions 职位管理
     * @return 结果
     */
    public int updateJobpositions(Jobpositions jobpositions);

    /**
     * 批量删除职位管理
     * 
     * @param ids 需要删除的职位管理主键集合
     * @return 结果
     */
    public int deleteJobpositionsByIds(Long[] ids);

    /**
     * 删除职位管理信息
     * 
     * @param id 职位管理主键
     * @return 结果
     */
    public int deleteJobpositionsById(Long id);
}
