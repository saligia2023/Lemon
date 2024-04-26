package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BlacklistcandidatesMapper;
import com.ruoyi.system.domain.Blacklistcandidates;
import com.ruoyi.system.service.IBlacklistcandidatesService;

/**
 * 黑名单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@Service
public class BlacklistcandidatesServiceImpl implements IBlacklistcandidatesService 
{
    @Autowired
    private BlacklistcandidatesMapper blacklistcandidatesMapper;

    /**
     * 查询黑名单
     * 
     * @param id 黑名单主键
     * @return 黑名单
     */
    @Override
    public Blacklistcandidates selectBlacklistcandidatesById(Long id)
    {
        return blacklistcandidatesMapper.selectBlacklistcandidatesById(id);
    }

    /**
     * 查询黑名单列表
     * 
     * @param blacklistcandidates 黑名单
     * @return 黑名单
     */
    @Override
    public List<Blacklistcandidates> selectBlacklistcandidatesList(Blacklistcandidates blacklistcandidates)
    {
        return blacklistcandidatesMapper.selectBlacklistcandidatesList(blacklistcandidates);
    }

    /**
     * 新增黑名单
     * 
     * @param blacklistcandidates 黑名单
     * @return 结果
     */
    @Override
    public int insertBlacklistcandidates(Blacklistcandidates blacklistcandidates)
    {
        return blacklistcandidatesMapper.insertBlacklistcandidates(blacklistcandidates);
    }

    /**
     * 修改黑名单
     * 
     * @param blacklistcandidates 黑名单
     * @return 结果
     */
    @Override
    public int updateBlacklistcandidates(Blacklistcandidates blacklistcandidates)
    {
        return blacklistcandidatesMapper.updateBlacklistcandidates(blacklistcandidates);
    }

    /**
     * 批量删除黑名单
     * 
     * @param ids 需要删除的黑名单主键
     * @return 结果
     */
    @Override
    public int deleteBlacklistcandidatesByIds(Long[] ids)
    {
        return blacklistcandidatesMapper.deleteBlacklistcandidatesByIds(ids);
    }

    /**
     * 删除黑名单信息
     * 
     * @param id 黑名单主键
     * @return 结果
     */
    @Override
    public int deleteBlacklistcandidatesById(Long id)
    {
        return blacklistcandidatesMapper.deleteBlacklistcandidatesById(id);
    }
}
