package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Blacklistcandidates;

/**
 * 黑名单Service接口
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public interface IBlacklistcandidatesService 
{
    /**
     * 查询黑名单
     * 
     * @param id 黑名单主键
     * @return 黑名单
     */
    public Blacklistcandidates selectBlacklistcandidatesById(Long id);

    /**
     * 查询黑名单列表
     * 
     * @param blacklistcandidates 黑名单
     * @return 黑名单集合
     */
    public List<Blacklistcandidates> selectBlacklistcandidatesList(Blacklistcandidates blacklistcandidates);

    /**
     * 新增黑名单
     * 
     * @param blacklistcandidates 黑名单
     * @return 结果
     */
    public int insertBlacklistcandidates(Blacklistcandidates blacklistcandidates);

    /**
     * 修改黑名单
     * 
     * @param blacklistcandidates 黑名单
     * @return 结果
     */
    public int updateBlacklistcandidates(Blacklistcandidates blacklistcandidates);

    /**
     * 批量删除黑名单
     * 
     * @param ids 需要删除的黑名单主键集合
     * @return 结果
     */
    public int deleteBlacklistcandidatesByIds(Long[] ids);

    /**
     * 删除黑名单信息
     * 
     * @param id 黑名单主键
     * @return 结果
     */
    public int deleteBlacklistcandidatesById(Long id);
}
