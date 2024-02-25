package com.swpu.identification.service;

import java.util.List;
import com.swpu.identification.domain.Cameraaccess;

/**
 * 摄像头接入Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface ICameraaccessService 
{
    /**
     * 查询摄像头接入
     * 
     * @param cameraId 摄像头接入主键
     * @return 摄像头接入
     */
    public Cameraaccess selectCameraaccessByCameraId(Integer cameraId);

    /**
     * 查询摄像头接入列表
     * 
     * @param cameraaccess 摄像头接入
     * @return 摄像头接入集合
     */
    public List<Cameraaccess> selectCameraaccessList(Cameraaccess cameraaccess);

    /**
     * 新增摄像头接入
     * 
     * @param cameraaccess 摄像头接入
     * @return 结果
     */
    public int insertCameraaccess(Cameraaccess cameraaccess);

    /**
     * 修改摄像头接入
     * 
     * @param cameraaccess 摄像头接入
     * @return 结果
     */
    public int updateCameraaccess(Cameraaccess cameraaccess);

    /**
     * 批量删除摄像头接入
     * 
     * @param cameraIds 需要删除的摄像头接入主键集合
     * @return 结果
     */
    public int deleteCameraaccessByCameraIds(Integer[] cameraIds);

    /**
     * 删除摄像头接入信息
     * 
     * @param cameraId 摄像头接入主键
     * @return 结果
     */
    public int deleteCameraaccessByCameraId(Integer cameraId);
}
