package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MainapplicantsMapper;
import com.ruoyi.system.domain.Mainapplicants;
import com.ruoyi.system.service.IMainapplicantsService;

/**
 * 应聘成员Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@Service
public class MainapplicantsServiceImpl implements IMainapplicantsService 
{
    @Autowired
    private MainapplicantsMapper mainapplicantsMapper;

    /**
     * 查询应聘成员
     * 
     * @param id 应聘成员主键
     * @return 应聘成员
     */
    @Override
    public Mainapplicants selectMainapplicantsById(Long id)
    {
        return mainapplicantsMapper.selectMainapplicantsById(id);
    }

    /**
     * 查询应聘成员列表
     * 
     * @param mainapplicants 应聘成员
     * @return 应聘成员
     */
    @Override
    public List<Mainapplicants> selectMainapplicantsList(Mainapplicants mainapplicants)
    {
        return mainapplicantsMapper.selectMainapplicantsList(mainapplicants);
    }

    /**
     * 新增应聘成员
     * 
     * @param mainapplicants 应聘成员
     * @return 结果
     */
    @Override
    public int insertMainapplicants(Mainapplicants mainapplicants)
    {
        return mainapplicantsMapper.insertMainapplicants(mainapplicants);
    }

    /**
     * 修改应聘成员
     * 
     * @param mainapplicants 应聘成员
     * @return 结果
     */
    @Override
    public int updateMainapplicants(Mainapplicants mainapplicants)
    {
        return mainapplicantsMapper.updateMainapplicants(mainapplicants);
    }

    /**
     * 批量删除应聘成员
     * 
     * @param ids 需要删除的应聘成员主键
     * @return 结果
     */
    @Override
    public int deleteMainapplicantsByIds(Long[] ids)
    {
        return mainapplicantsMapper.deleteMainapplicantsByIds(ids);
    }

    /**
     * 删除应聘成员信息
     * 
     * @param id 应聘成员主键
     * @return 结果
     */
    @Override
    public int deleteMainapplicantsById(Long id)
    {
        return mainapplicantsMapper.deleteMainapplicantsById(id);
    }
}
