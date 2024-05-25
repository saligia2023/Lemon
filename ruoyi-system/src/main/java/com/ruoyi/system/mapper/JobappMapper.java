package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Jobapp;

/**
 * 招聘信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-17
 */
public interface JobappMapper 
{
    /**
     * 查询招聘信息
     * 
     * @param id 招聘信息主键
     * @return 招聘信息
     */
    public Jobapp selectJobappById(Long id);

    /**
     * 查询招聘信息列表
     * 
     * @param jobapp 招聘信息
     * @return 招聘信息集合
     */
    public List<Jobapp> selectJobappList(Jobapp jobapp);

    /**
     * 新增招聘信息
     * 
     * @param jobapp 招聘信息
     * @return 结果
     */
    public int insertJobapp(Jobapp jobapp);

    /**
     * 修改招聘信息
     * 
     * @param jobapp 招聘信息
     * @return 结果
     */
    public int updateJobapp(Jobapp jobapp);

    /**
     * 删除招聘信息
     * 
     * @param id 招聘信息主键
     * @return 结果
     */
    public int deleteJobappById(Long id);

    /**
     * 批量删除招聘信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobappByIds(Long[] ids);
}
