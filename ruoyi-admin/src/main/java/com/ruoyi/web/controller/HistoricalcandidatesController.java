package com.ruoyi.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Historicalcandidates;
import com.ruoyi.system.service.IHistoricalcandidatesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史人才库Controller
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@RestController
@RequestMapping("/system/historicalcandidates")
public class HistoricalcandidatesController extends BaseController {
    @Autowired
    private IHistoricalcandidatesService historicalcandidatesService;

    /**
     * 查询历史人才库列表
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:list')")
    @GetMapping("/list")
    public TableDataInfo list(Historicalcandidates historicalcandidates) {
        startPage();
        List<Historicalcandidates> list = historicalcandidatesService
                .selectHistoricalcandidatesList(historicalcandidates);
        return getDataTable(list);
    }

    /**
     * 导出历史人才库列表
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:export')")
    @Log(title = "历史人才库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Historicalcandidates historicalcandidates) {
        List<Historicalcandidates> list = historicalcandidatesService
                .selectHistoricalcandidatesList(historicalcandidates);
        ExcelUtil<Historicalcandidates> util = new ExcelUtil<Historicalcandidates>(Historicalcandidates.class);
        util.exportExcel(response, list, "历史人才库数据");
    }

    /**
     * 获取历史人才库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(historicalcandidatesService.selectHistoricalcandidatesById(id));
    }

    /**
     * 新增历史人才库
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:add')")
    @Log(title = "历史人才库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Historicalcandidates historicalcandidates) {
        return toAjax(historicalcandidatesService.insertHistoricalcandidates(historicalcandidates));
    }

    /**
     * 修改历史人才库
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:edit')")
    @Log(title = "历史人才库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Historicalcandidates historicalcandidates) {
        return toAjax(historicalcandidatesService.updateHistoricalcandidates(historicalcandidates));
    }

    /**
     * 删除历史人才库
     */
    @PreAuthorize("@ss.hasPermi('system:historicalcandidates:remove')")
    @Log(title = "历史人才库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(historicalcandidatesService.deleteHistoricalcandidatesByIds(ids));
    }
}
