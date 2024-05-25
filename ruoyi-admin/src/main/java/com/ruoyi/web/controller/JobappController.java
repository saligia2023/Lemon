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
import com.ruoyi.system.domain.Jobapp;
import com.ruoyi.system.service.IJobappService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘信息Controller
 * 
 * @author ruoyi
 * @date 2024-05-17
 */
@RestController
@RequestMapping("/system/jobapp")
public class JobappController extends BaseController {
    @Autowired
    private IJobappService jobappService;

    /**
     * 查询招聘信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:list')")
    @GetMapping("/list")
    public TableDataInfo list(Jobapp jobapp) {
        startPage();
        List<Jobapp> list = jobappService.selectJobappList(jobapp);
        return getDataTable(list);
    }

    /**
     * 导出招聘信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:export')")
    @Log(title = "招聘信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Jobapp jobapp) {
        List<Jobapp> list = jobappService.selectJobappList(jobapp);
        ExcelUtil<Jobapp> util = new ExcelUtil<Jobapp>(Jobapp.class);
        util.exportExcel(response, list, "招聘信息数据");
    }

    /**
     * 获取招聘信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(jobappService.selectJobappById(id));
    }

    /**
     * 新增招聘信息
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:add')")
    @Log(title = "招聘信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Jobapp jobapp) {
        return toAjax(jobappService.insertJobapp(jobapp));
    }

    /**
     * 修改招聘信息
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:edit')")
    @Log(title = "招聘信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Jobapp jobapp) {
        return toAjax(jobappService.updateJobapp(jobapp));
    }

    /**
     * 删除招聘信息
     */
    @PreAuthorize("@ss.hasPermi('system:jobapp:remove')")
    @Log(title = "招聘信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(jobappService.deleteJobappByIds(ids));
    }
}
