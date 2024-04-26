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
import com.ruoyi.system.domain.Applicant;
import com.ruoyi.system.service.IApplicantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-24
 */
@RestController
@RequestMapping("/system/applicant")
public class ApplicantController extends BaseController {
    @Autowired
    private IApplicantService applicantService;

    /**
     * 查询招聘管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:list')")
    @GetMapping("/list")
    public TableDataInfo list(Applicant applicant) {
        startPage();
        List<Applicant> list = applicantService.selectApplicantList(applicant);
        return getDataTable(list);
    }

    /**
     * 导出招聘管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:export')")
    @Log(title = "招聘管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Applicant applicant) {
        List<Applicant> list = applicantService.selectApplicantList(applicant);
        ExcelUtil<Applicant> util = new ExcelUtil<Applicant>(Applicant.class);
        util.exportExcel(response, list, "招聘管理数据");
    }

    /**
     * 获取招聘管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId) {
        return success(applicantService.selectApplicantByUserId(userId));
    }

    /**
     * 新增招聘管理
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:add')")
    @Log(title = "招聘管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Applicant applicant) {
        return toAjax(applicantService.insertApplicant(applicant));
    }

    /**
     * 修改招聘管理
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:edit')")
    @Log(title = "招聘管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Applicant applicant) {
        return toAjax(applicantService.updateApplicant(applicant));
    }

    /**
     * 删除招聘管理
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:remove')")
    @Log(title = "招聘管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        return toAjax(applicantService.deleteApplicantByUserIds(userIds));
    }
}
