package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Applicant;

/**
 * 招聘管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public interface ApplicantMapper 
{
    /**
     * 查询招聘管理
     * 
     * @param userId 招聘管理主键
     * @return 招聘管理
     */
    public Applicant selectApplicantByUserId(Long userId);

    /**
     * 查询招聘管理列表
     * 
     * @param applicant 招聘管理
     * @return 招聘管理集合
     */
    public List<Applicant> selectApplicantList(Applicant applicant);

    /**
     * 新增招聘管理
     * 
     * @param applicant 招聘管理
     * @return 结果
     */
    public int insertApplicant(Applicant applicant);

    /**
     * 修改招聘管理
     * 
     * @param applicant 招聘管理
     * @return 结果
     */
    public int updateApplicant(Applicant applicant);

    /**
     * 删除招聘管理
     * 
     * @param userId 招聘管理主键
     * @return 结果
     */
    public int deleteApplicantByUserId(Long userId);

    /**
     * 批量删除招聘管理
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApplicantByUserIds(Long[] userIds);
}
