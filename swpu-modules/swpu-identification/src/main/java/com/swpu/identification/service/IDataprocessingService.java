package com.swpu.identification.service;

import java.util.List;
import com.swpu.identification.domain.Dataprocessing;

/**
 * 数据处理Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface IDataprocessingService 
{
    /**
     * 查询数据处理
     * 
     * @param dataId 数据处理主键
     * @return 数据处理
     */
    public Dataprocessing selectDataprocessingByDataId(Integer dataId);

    /**
     * 查询数据处理列表
     * 
     * @param dataprocessing 数据处理
     * @return 数据处理集合
     */
    public List<Dataprocessing> selectDataprocessingList(Dataprocessing dataprocessing);

    /**
     * 新增数据处理
     * 
     * @param dataprocessing 数据处理
     * @return 结果
     */
    public int insertDataprocessing(Dataprocessing dataprocessing);

    /**
     * 修改数据处理
     * 
     * @param dataprocessing 数据处理
     * @return 结果
     */
    public int updateDataprocessing(Dataprocessing dataprocessing);

    /**
     * 批量删除数据处理
     * 
     * @param dataIds 需要删除的数据处理主键集合
     * @return 结果
     */
    public int deleteDataprocessingByDataIds(Integer[] dataIds);

    /**
     * 删除数据处理信息
     * 
     * @param dataId 数据处理主键
     * @return 结果
     */
    public int deleteDataprocessingByDataId(Integer dataId);
}
