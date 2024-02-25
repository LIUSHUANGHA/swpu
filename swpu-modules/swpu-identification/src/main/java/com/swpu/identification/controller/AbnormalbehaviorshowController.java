package com.swpu.identification.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swpu.common.log.annotation.Log;
import com.swpu.common.log.enums.BusinessType;
import com.swpu.common.security.annotation.RequiresPermissions;
import com.swpu.identification.domain.Abnormalbehaviorshow;
import com.swpu.identification.service.IAbnormalbehaviorshowService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 异常行为展示Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/abnormalbehaviorshow")
public class AbnormalbehaviorshowController extends BaseController
{
    @Autowired
    private IAbnormalbehaviorshowService abnormalbehaviorshowService;

    /**
     * 查询异常行为展示列表
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:list")
    @GetMapping("/list")
    public TableDataInfo list(Abnormalbehaviorshow abnormalbehaviorshow)
    {
        startPage();
        List<Abnormalbehaviorshow> list = abnormalbehaviorshowService.selectAbnormalbehaviorshowList(abnormalbehaviorshow);
        return getDataTable(list);
    }

    /**
     * 导出异常行为展示列表
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:export")
    @Log(title = "异常行为展示", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Abnormalbehaviorshow abnormalbehaviorshow)
    {
        List<Abnormalbehaviorshow> list = abnormalbehaviorshowService.selectAbnormalbehaviorshowList(abnormalbehaviorshow);
        ExcelUtil<Abnormalbehaviorshow> util = new ExcelUtil<Abnormalbehaviorshow>(Abnormalbehaviorshow.class);
        util.exportExcel(response, list, "异常行为展示数据");
    }

    /**
     * 获取异常行为展示详细信息
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:query")
    @GetMapping(value = "/{identificationId}")
    public AjaxResult getInfo(@PathVariable("identificationId") Integer identificationId)
    {
        return success(abnormalbehaviorshowService.selectAbnormalbehaviorshowByIdentificationId(identificationId));
    }

    /**
     * 新增异常行为展示
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:add")
    @Log(title = "异常行为展示", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Abnormalbehaviorshow abnormalbehaviorshow)
    {
        return toAjax(abnormalbehaviorshowService.insertAbnormalbehaviorshow(abnormalbehaviorshow));
    }

    /**
     * 修改异常行为展示
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:edit")
    @Log(title = "异常行为展示", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Abnormalbehaviorshow abnormalbehaviorshow)
    {
        return toAjax(abnormalbehaviorshowService.updateAbnormalbehaviorshow(abnormalbehaviorshow));
    }

    /**
     * 删除异常行为展示
     */
    @RequiresPermissions("identification:abnormalbehaviorshow:remove")
    @Log(title = "异常行为展示", businessType = BusinessType.DELETE)
	@DeleteMapping("/{identificationIds}")
    public AjaxResult remove(@PathVariable Integer[] identificationIds)
    {
        return toAjax(abnormalbehaviorshowService.deleteAbnormalbehaviorshowByIdentificationIds(identificationIds));
    }
}
