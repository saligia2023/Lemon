package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Mainapplicants;

/**
 * 应聘成员Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public interface MainapplicantsMapper 
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
     * 删除应聘成员
     * 
     * @param id 应聘成员主键
     * @return 结果
     */
    public int deleteMainapplicantsById(Long id);

    /**
     * 批量删除应聘成员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMainapplicantsByIds(Long[] ids);
}
