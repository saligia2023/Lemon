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
import com.ruoyi.system.domain.Blacklistcandidates;
import com.ruoyi.system.service.IBlacklistcandidatesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 黑名单Controller
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@RestController
@RequestMapping("/system/blacklistcandidates")
public class BlacklistcandidatesController extends BaseController {
    @Autowired
    private IBlacklistcandidatesService blacklistcandidatesService;

    /**
     * 查询黑名单列表
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:list')")
    @GetMapping("/list")
    public TableDataInfo list(Blacklistcandidates blacklistcandidates) {
        startPage();
        List<Blacklistcandidates> list = blacklistcandidatesService.selectBlacklistcandidatesList(blacklistcandidates);
        return getDataTable(list);
    }

    /**
     * 导出黑名单列表
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:export')")
    @Log(title = "黑名单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Blacklistcandidates blacklistcandidates) {
        List<Blacklistcandidates> list = blacklistcandidatesService.selectBlacklistcandidatesList(blacklistcandidates);
        ExcelUtil<Blacklistcandidates> util = new ExcelUtil<Blacklistcandidates>(Blacklistcandidates.class);
        util.exportExcel(response, list, "黑名单数据");
    }

    /**
     * 获取黑名单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blacklistcandidatesService.selectBlacklistcandidatesById(id));
    }

    /**
     * 新增黑名单
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:add')")
    @Log(title = "黑名单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Blacklistcandidates blacklistcandidates) {
        return toAjax(blacklistcandidatesService.insertBlacklistcandidates(blacklistcandidates));
    }

    /**
     * 修改黑名单
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:edit')")
    @Log(title = "黑名单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Blacklistcandidates blacklistcandidates) {
        return toAjax(blacklistcandidatesService.updateBlacklistcandidates(blacklistcandidates));
    }

    /**
     * 删除黑名单
     */
    @PreAuthorize("@ss.hasPermi('system:blacklistcandidates:remove')")
    @Log(title = "黑名单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blacklistcandidatesService.deleteBlacklistcandidatesByIds(ids));
    }
}
