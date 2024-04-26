package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Mainapplicants;

/**
 * 应聘成员Service接口
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public interface IMainapplicantsService 
{
    /**
     * 查询应聘成员
     * 
     * @param id 应聘成员主键
     * @return 应聘成员
     */
    public Mainapplicants selectMainapplicantsById(Long id);

    /**
     * 查询应聘成员列表
     * 
     * @param mainapplicants 应聘成员
     * @return 应聘成员集合
     */
    public List<Mainapplicants> selectMainapplicantsList(Mainapplicants mainapplicants);

    /**
     * 新增应聘成员
     * 
     * @param mainapplicants 应聘成员
     * @return 结果
     */
    public int insertMainapplicants(Mainapplicants mainapplicants);

    /**
     * 修改应聘成员
     * 
     * @param mainapplicants 应聘成员
     * @return 结果
     */
    public int updateMainapplicants(Mainapplicants mainapplicants);

    /**
     * 批量删除应聘成员
     * 
     * @param ids 需要删除的应聘成员主键集合
     * @return 结果
     */
    public int deleteMainapplicantsByIds(Long[] ids);

    /**
     * 删除应聘成员信息
     * 
     * @param id 应聘成员主键
     * @return 结果
     */
    public int deleteMainapplicantsById(Long id);
}
