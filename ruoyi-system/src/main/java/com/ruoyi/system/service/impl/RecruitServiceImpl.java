package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecruitMapper;
import com.ruoyi.system.domain.Recruit;
import com.ruoyi.system.service.IRecruitService;

/**
 * 应聘Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-27
 */
@Service
public class RecruitServiceImpl implements IRecruitService 
{
    @Autowired
    private RecruitMapper recruitMapper;

    /**
     * 查询应聘
     * 
     * @param UserID 应聘主键
     * @return 应聘
     */
    @Override
    public Recruit selectRecruitByUserID(Long UserID)
    {
        return recruitMapper.selectRecruitByUserID(UserID);
    }

    /**
     * 查询应聘列表
     * 
     * @param recruit 应聘
     * @return 应聘
     */
    @Override
    public List<Recruit> selectRecruitList(Recruit recruit)
    {
        return recruitMapper.selectRecruitList(recruit);
    }

    /**
     * 新增应聘
     * 
     * @param recruit 应聘
     * @return 结果
     */
    @Override
    public int insertRecruit(Recruit recruit)
    {
        return recruitMapper.insertRecruit(recruit);
    }

    /**
     * 修改应聘
     * 
     * @param recruit 应聘
     * @return 结果
     */
    @Override
    public int updateRecruit(Recruit recruit)
    {
        return recruitMapper.updateRecruit(recruit);
    }

    /**
     * 批量删除应聘
     * 
     * @param UserIDs 需要删除的应聘主键
     * @return 结果
     */
    @Override
    public int deleteRecruitByUserIDs(Long[] UserIDs)
    {
        return recruitMapper.deleteRecruitByUserIDs(UserIDs);
    }

    /**
     * 删除应聘信息
     * 
     * @param UserID 应聘主键
     * @return 结果
     */
    @Override
    public int deleteRecruitByUserID(Long UserID)
    {
        return recruitMapper.deleteRecruitByUserID(UserID);
    }
}
