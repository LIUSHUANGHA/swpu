package com.swpu.identification.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.identification.mapper.CameraaccessMapper;
import com.swpu.identification.domain.Cameraaccess;
import com.swpu.identification.service.ICameraaccessService;

/**
 * 摄像头接入Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class CameraaccessServiceImpl implements ICameraaccessService 
{
    @Autowired
    private CameraaccessMapper cameraaccessMapper;

    /**
     * 查询摄像头接入
     * 
     * @param cameraId 摄像头接入主键
     * @return 摄像头接入
     */
    @Override
    public Cameraaccess selectCameraaccessByCameraId(Integer cameraId)
    {
        return cameraaccessMapper.selectCameraaccessByCameraId(cameraId);
    }

    /**
     * 查询摄像头接入列表
     * 
     * @param cameraaccess 摄像头接入
     * @return 摄像头接入
     */
    @Override
    public List<Cameraaccess> selectCameraaccessList(Cameraaccess cameraaccess)
    {
        return cameraaccessMapper.selectCameraaccessList(cameraaccess);
    }

    /**
     * 新增摄像头接入
     * 
     * @param cameraaccess 摄像头接入
     * @return 结果
     */
    @Override
    public int insertCameraaccess(Cameraaccess cameraaccess)
    {
        return cameraaccessMapper.insertCameraaccess(cameraaccess);
    }

    /**
     * 修改摄像头接入
     * 
     * @param cameraaccess 摄像头接入
     * @return 结果
     */
    @Override
    public int updateCameraaccess(Cameraaccess cameraaccess)
    {
        return cameraaccessMapper.updateCameraaccess(cameraaccess);
    }

    /**
     * 批量删除摄像头接入
     * 
     * @param cameraIds 需要删除的摄像头接入主键
     * @return 结果
     */
    @Override
    public int deleteCameraaccessByCameraIds(Integer[] cameraIds)
    {
        return cameraaccessMapper.deleteCameraaccessByCameraIds(cameraIds);
    }

    /**
     * 删除摄像头接入信息
     * 
     * @param cameraId 摄像头接入主键
     * @return 结果
     */
    @Override
    public int deleteCameraaccessByCameraId(Integer cameraId)
    {
        return cameraaccessMapper.deleteCameraaccessByCameraId(cameraId);
    }
}
