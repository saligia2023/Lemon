package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ApplicantMapper;
import com.ruoyi.system.domain.Applicant;
import com.ruoyi.system.service.IApplicantService;

/**
 * 招聘管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@Service
public class ApplicantServiceImpl implements IApplicantService 
{
    @Autowired
    private ApplicantMapper applicantMapper;

    /**
     * 查询招聘管理
     * 
     * @param userId 招聘管理主键
     * @return 招聘管理
     */
    @Override
    public Applicant selectApplicantByUserId(Long userId)
    {
        return applicantMapper.selectApplicantByUserId(userId);
    }

    /**
     * 查询招聘管理列表
     * 
     * @param applicant 招聘管理
     * @return 招聘管理
     */
    @Override
    public List<Applicant> selectApplicantList(Applicant applicant)
    {
        return applicantMapper.selectApplicantList(applicant);
    }

    /**
     * 新增招聘管理
     * 
     * @param applicant 招聘管理
     * @return 结果
     */
    @Override
    public int insertApplicant(Applicant applicant)
    {
        return applicantMapper.insertApplicant(applicant);
    }

    /**
     * 修改招聘管理
     * 
     * @param applicant 招聘管理
     * @return 结果
     */
    @Override
    public int updateApplicant(Applicant applicant)
    {
        return applicantMapper.updateApplicant(applicant);
    }

    /**
     * 批量删除招聘管理
     * 
     * @param userIds 需要删除的招聘管理主键
     * @return 结果
     */
    @Override
    public int deleteApplicantByUserIds(Long[] userIds)
    {
        return applicantMapper.deleteApplicantByUserIds(userIds);
    }

    /**
     * 删除招聘管理信息
     * 
     * @param userId 招聘管理主键
     * @return 结果
     */
    @Override
    public int deleteApplicantByUserId(Long userId)
    {
        return applicantMapper.deleteApplicantByUserId(userId);
    }
}
