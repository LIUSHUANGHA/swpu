package com.swpu.identification.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.identification.mapper.DataprocessingMapper;
import com.swpu.identification.domain.Dataprocessing;
import com.swpu.identification.service.IDataprocessingService;

/**
 * 数据处理Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class DataprocessingServiceImpl implements IDataprocessingService 
{
    @Autowired
    private DataprocessingMapper dataprocessingMapper;

    /**
     * 查询数据处理
     * 
     * @param dataId 数据处理主键
     * @return 数据处理
     */
    @Override
    public Dataprocessing selectDataprocessingByDataId(Integer dataId)
    {
        return dataprocessingMapper.selectDataprocessingByDataId(dataId);
    }

    /**
     * 查询数据处理列表
     * 
     * @param dataprocessing 数据处理
     * @return 数据处理
     */
    @Override
    public List<Dataprocessing> selectDataprocessingList(Dataprocessing dataprocessing)
    {
        return dataprocessingMapper.selectDataprocessingList(dataprocessing);
    }

    /**
     * 新增数据处理
     * 
     * @param dataprocessing 数据处理
     * @return 结果
     */
    @Override
    public int insertDataprocessing(Dataprocessing dataprocessing)
    {
        return dataprocessingMapper.insertDataprocessing(dataprocessing);
    }

    /**
     * 修改数据处理
     * 
     * @param dataprocessing 数据处理
     * @return 结果
     */
    @Override
    public int updateDataprocessing(Dataprocessing dataprocessing)
    {
        return dataprocessingMapper.updateDataprocessing(dataprocessing);
    }

    /**
     * 批量删除数据处理
     * 
     * @param dataIds 需要删除的数据处理主键
     * @return 结果
     */
    @Override
    public int deleteDataprocessingByDataIds(Integer[] dataIds)
    {
        return dataprocessingMapper.deleteDataprocessingByDataIds(dataIds);
    }

    /**
     * 删除数据处理信息
     * 
     * @param dataId 数据处理主键
     * @return 结果
     */
    @Override
    public int deleteDataprocessingByDataId(Integer dataId)
    {
        return dataprocessingMapper.deleteDataprocessingByDataId(dataId);
    }
}
