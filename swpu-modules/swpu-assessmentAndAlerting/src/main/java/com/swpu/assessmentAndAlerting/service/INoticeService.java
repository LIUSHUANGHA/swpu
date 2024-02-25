package com.swpu.assessmentAndAlerting.service;

import java.util.List;
import com.swpu.assessmentAndAlerting.domain.Notice;

/**
 * 通知Service接口
 * 
 * @author liushuang
 * @date 2024-02-02
 */
public interface INoticeService 
{
    /**
     * 查询通知
     * 
     * @param noticeId 通知主键
     * @return 通知
     */
    public Notice selectNoticeByNoticeId(Integer noticeId);

    /**
     * 查询通知列表
     * 
     * @param notice 通知
     * @return 通知集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增通知
     * 
     * @param notice 通知
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改通知
     * 
     * @param notice 通知
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 批量删除通知
     * 
     * @param noticeIds 需要删除的通知主键集合
     * @return 结果
     */
    public int deleteNoticeByNoticeIds(Integer[] noticeIds);

    /**
     * 删除通知信息
     * 
     * @param noticeId 通知主键
     * @return 结果
     */
    public int deleteNoticeByNoticeId(Integer noticeId);
}
