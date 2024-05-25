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
import com.ruoyi.system.domain.Recruit;
import com.ruoyi.system.service.IRecruitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应聘Controller
 * 
 * @author ruoyi
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/system/recruit")
public class RecruitController extends BaseController {
    @Autowired
    private IRecruitService recruitService;

    /**
     * 查询应聘列表
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:list')")
    @GetMapping("/list")
    public TableDataInfo list(Recruit recruit) {
        startPage();
        List<Recruit> list = recruitService.selectRecruitList(recruit);
        return getDataTable(list);
    }

    /**
     * 导出应聘列表
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:export')")
    @Log(title = "应聘", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Recruit recruit) {
        List<Recruit> list = recruitService.selectRecruitList(recruit);
        ExcelUtil<Recruit> util = new ExcelUtil<Recruit>(Recruit.class);
        util.exportExcel(response, list, "应聘数据");
    }

    /**
     * 获取应聘详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:query')")
    @GetMapping(value = "/{UserID}")
    public AjaxResult getInfo(@PathVariable("UserID") Long UserID) {
        return success(recruitService.selectRecruitByUserID(UserID));
    }

    /**
     * 新增应聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:add')")
    @Log(title = "应聘", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Recruit recruit) {
        return toAjax(recruitService.insertRecruit(recruit));
    }

    /**
     * 修改应聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:edit')")
    @Log(title = "应聘", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Recruit recruit) {
        return toAjax(recruitService.updateRecruit(recruit));
    }

    /**
     * 删除应聘
     */
    @PreAuthorize("@ss.hasPermi('system:recruit:remove')")
    @Log(title = "应聘", businessType = BusinessType.DELETE)
    @DeleteMapping("/{UserIDs}")
    public AjaxResult remove(@PathVariable Long[] UserIDs) {
        return toAjax(recruitService.deleteRecruitByUserIDs(UserIDs));
    }
}
