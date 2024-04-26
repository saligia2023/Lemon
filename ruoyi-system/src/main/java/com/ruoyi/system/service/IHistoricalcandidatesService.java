package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Historicalcandidates;

/**
 * 历史人才库Service接口
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
public interface IHistoricalcandidatesService 
{
    /**
     * 查询历史人才库
     * 
     * @param id 历史人才库主键
     * @return 历史人才库
     */
    public Historicalcandidates selectHistoricalcandidatesById(Long id);

    /**
     * 查询历史人才库列表
     * 
     * @param historicalcandidates 历史人才库
     * @return 历史人才库集合
     */
    public List<Historicalcandidates> selectHistoricalcandidatesList(Historicalcandidates historicalcandidates);

    /**
     * 新增历史人才库
     * 
     * @param historicalcandidates 历史人才库
     * @return 结果
     */
    public int insertHistoricalcandidates(Historicalcandidates historicalcandidates);

    /**
     * 修改历史人才库
     * 
     * @param historicalcandidates 历史人才库
     * @return 结果
     */
    public int updateHistoricalcandidates(Historicalcandidates historicalcandidates);

    /**
     * 批量删除历史人才库
     * 
     * @param ids 需要删除的历史人才库主键集合
     * @return 结果
     */
    public int deleteHistoricalcandidatesByIds(Long[] ids);

    /**
     * 删除历史人才库信息
     * 
     * @param id 历史人才库主键
     * @return 结果
     */
    public int deleteHistoricalcandidatesById(Long id);
}
