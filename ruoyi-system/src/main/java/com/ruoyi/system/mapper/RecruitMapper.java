package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Recruit;

/**
 * 应聘Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-27
 */
public interface RecruitMapper 
{
    /**
     * 查询应聘
     * 
     * @param UserID 应聘主键
     * @return 应聘
     */
    public Recruit selectRecruitByUserID(Long UserID);

    /**
     * 查询应聘列表
     * 
     * @param recruit 应聘
     * @return 应聘集合
     */
    public List<Recruit> selectRecruitList(Recruit recruit);

    /**
     * 新增应聘
     * 
     * @param recruit 应聘
     * @return 结果
     */
    public int insertRecruit(Recruit recruit);

    /**
     * 修改应聘
     * 
     * @param recruit 应聘
     * @return 结果
     */
    public int updateRecruit(Recruit recruit);

    /**
     * 删除应聘
     * 
     * @param UserID 应聘主键
     * @return 结果
     */
    public int deleteRecruitByUserID(Long UserID);

    /**
     * 批量删除应聘
     * 
     * @param UserIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecruitByUserIDs(Long[] UserIDs);
}
