package com.swpu.assessmentAndAlerting.controller;

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
import com.swpu.assessmentAndAlerting.domain.Alrmconfiguration;
import com.swpu.assessmentAndAlerting.service.IAlrmconfigurationService;
import com.swpu.common.core.web.controller.BaseController;
import com.swpu.common.core.web.domain.AjaxResult;
import com.swpu.common.core.utils.poi.ExcelUtil;
import com.swpu.common.core.web.page.TableDataInfo;

/**
 * 告警配置管理Controller
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/alrmconfiguration")
public class AlrmconfigurationController extends BaseController
{
    @Autowired
    private IAlrmconfigurationService alrmconfigurationService;

    /**
     * 查询告警配置管理列表
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:list")
    @GetMapping("/list")
    public TableDataInfo list(Alrmconfiguration alrmconfiguration)
    {
        startPage();
        List<Alrmconfiguration> list = alrmconfigurationService.selectAlrmconfigurationList(alrmconfiguration);
        return getDataTable(list);
    }

    /**
     * 导出告警配置管理列表
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:export")
    @Log(title = "告警配置管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Alrmconfiguration alrmconfiguration)
    {
        List<Alrmconfiguration> list = alrmconfigurationService.selectAlrmconfigurationList(alrmconfiguration);
        ExcelUtil<Alrmconfiguration> util = new ExcelUtil<Alrmconfiguration>(Alrmconfiguration.class);
        util.exportExcel(response, list, "告警配置管理数据");
    }

    /**
     * 获取告警配置管理详细信息
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:query")
    @GetMapping(value = "/{alarmId}")
    public AjaxResult getInfo(@PathVariable("alarmId") Long alarmId)
    {
        return success(alrmconfigurationService.selectAlrmconfigurationByAlarmId(alarmId));
    }

    /**
     * 新增告警配置管理
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:add")
    @Log(title = "告警配置管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Alrmconfiguration alrmconfiguration)
    {
        return toAjax(alrmconfigurationService.insertAlrmconfiguration(alrmconfiguration));
    }

    /**
     * 修改告警配置管理
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:edit")
    @Log(title = "告警配置管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Alrmconfiguration alrmconfiguration)
    {
        return toAjax(alrmconfigurationService.updateAlrmconfiguration(alrmconfiguration));
    }

    /**
     * 删除告警配置管理
     */
    @RequiresPermissions("assessmentAndAlerting:alrmconfiguration:remove")
    @Log(title = "告警配置管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{alarmIds}")
    public AjaxResult remove(@PathVariable Long[] alarmIds)
    {
        return toAjax(alrmconfigurationService.deleteAlrmconfigurationByAlarmIds(alarmIds));
    }
}
