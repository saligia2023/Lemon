package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HistoricalcandidatesMapper;
import com.ruoyi.system.domain.Historicalcandidates;
import com.ruoyi.system.service.IHistoricalcandidatesService;

/**
 * 历史人才库Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@Service
public class HistoricalcandidatesServiceImpl implements IHistoricalcandidatesService 
{
    @Autowired
    private HistoricalcandidatesMapper historicalcandidatesMapper;

    /**
     * 查询历史人才库
     * 
     * @param id 历史人才库主键
     * @return 历史人才库
     */
    @Override
    public Historicalcandidates selectHistoricalcandidatesById(Long id)
    {
        return historicalcandidatesMapper.selectHistoricalcandidatesById(id);
    }

    /**
     * 查询历史人才库列表
     * 
     * @param historicalcandidates 历史人才库
     * @return 历史人才库
     */
    @Override
    public List<Historicalcandidates> selectHistoricalcandidatesList(Historicalcandidates historicalcandidates)
    {
        return historicalcandidatesMapper.selectHistoricalcandidatesList(historicalcandidates);
    }

    /**
     * 新增历史人才库
     * 
     * @param historicalcandidates 历史人才库
     * @return 结果
     */
    @Override
    public int insertHistoricalcandidates(Historicalcandidates historicalcandidates)
    {
        return historicalcandidatesMapper.insertHistoricalcandidates(historicalcandidates);
    }

    /**
     * 修改历史人才库
     * 
     * @param historicalcandidates 历史人才库
     * @return 结果
     */
    @Override
    public int updateHistoricalcandidates(Historicalcandidates historicalcandidates)
    {
        return historicalcandidatesMapper.updateHistoricalcandidates(historicalcandidates);
    }

    /**
     * 批量删除历史人才库
     * 
     * @param ids 需要删除的历史人才库主键
     * @return 结果
     */
    @Override
    public int deleteHistoricalcandidatesByIds(Long[] ids)
    {
        return historicalcandidatesMapper.deleteHistoricalcandidatesByIds(ids);
    }

    /**
     * 删除历史人才库信息
     * 
     * @param id 历史人才库主键
     * @return 结果
     */
    @Override
    public int deleteHistoricalcandidatesById(Long id)
    {
        return historicalcandidatesMapper.deleteHistoricalcandidatesById(id);
    }
}
