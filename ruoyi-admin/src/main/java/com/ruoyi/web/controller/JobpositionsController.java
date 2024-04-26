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
import com.ruoyi.system.domain.Jobpositions;
import com.ruoyi.system.service.IJobpositionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职位管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-25
 */
@RestController
@RequestMapping("/system/jobpositions")
public class JobpositionsController extends BaseController {
    @Autowired
    private IJobpositionsService jobpositionsService;

    /**
     * 查询职位管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:list')")
    @GetMapping("/list")
    public TableDataInfo list(Jobpositions jobpositions) {
        startPage();
        List<Jobpositions> list = jobpositionsService.selectJobpositionsList(jobpositions);
        return getDataTable(list);
    }

    /**
     * 导出职位管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:export')")
    @Log(title = "职位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Jobpositions jobpositions) {
        List<Jobpositions> list = jobpositionsService.selectJobpositionsList(jobpositions);
        ExcelUtil<Jobpositions> util = new ExcelUtil<Jobpositions>(Jobpositions.class);
        util.exportExcel(response, list, "职位管理数据");
    }

    /**
     * 获取职位管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(jobpositionsService.selectJobpositionsById(id));
    }

    /**
     * 新增职位管理
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:add')")
    @Log(title = "职位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Jobpositions jobpositions) {
        return toAjax(jobpositionsService.insertJobpositions(jobpositions));
    }

    /**
     * 修改职位管理
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:edit')")
    @Log(title = "职位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Jobpositions jobpositions) {
        return toAjax(jobpositionsService.updateJobpositions(jobpositions));
    }

    /**
     * 删除职位管理
     */
    @PreAuthorize("@ss.hasPermi('system:jobpositions:remove')")
    @Log(title = "职位管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(jobpositionsService.deleteJobpositionsByIds(ids));
    }
}
