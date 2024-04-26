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
import com.ruoyi.system.domain.Mainapplicants;
import com.ruoyi.system.service.IMainapplicantsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应聘成员Controller
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@RestController
@RequestMapping("/system/mainapplicants")
public class MainapplicantsController extends BaseController {
    @Autowired
    private IMainapplicantsService mainapplicantsService;

    /**
     * 查询应聘成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:list')")
    @GetMapping("/list")
    public TableDataInfo list(Mainapplicants mainapplicants) {
        startPage();
        List<Mainapplicants> list = mainapplicantsService.selectMainapplicantsList(mainapplicants);
        return getDataTable(list);
    }

    /**
     * 导出应聘成员列表
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:export')")
    @Log(title = "应聘成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Mainapplicants mainapplicants) {
        List<Mainapplicants> list = mainapplicantsService.selectMainapplicantsList(mainapplicants);
        ExcelUtil<Mainapplicants> util = new ExcelUtil<Mainapplicants>(Mainapplicants.class);
        util.exportExcel(response, list, "应聘成员数据");
    }

    /**
     * 获取应聘成员详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(mainapplicantsService.selectMainapplicantsById(id));
    }

    /**
     * 新增应聘成员
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:add')")
    @Log(title = "应聘成员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Mainapplicants mainapplicants) {
        return toAjax(mainapplicantsService.insertMainapplicants(mainapplicants));
    }

    /**
     * 修改应聘成员
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:edit')")
    @Log(title = "应聘成员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Mainapplicants mainapplicants) {
        return toAjax(mainapplicantsService.updateMainapplicants(mainapplicants));
    }

    /**
     * 删除应聘成员
     */
    @PreAuthorize("@ss.hasPermi('system:mainapplicants:remove')")
    @Log(title = "应聘成员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mainapplicantsService.deleteMainapplicantsByIds(ids));
    }
}
