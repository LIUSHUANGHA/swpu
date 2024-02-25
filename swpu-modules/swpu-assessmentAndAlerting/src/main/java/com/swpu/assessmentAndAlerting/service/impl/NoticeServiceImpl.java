package com.swpu.assessmentAndAlerting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swpu.assessmentAndAlerting.mapper.NoticeMapper;
import com.swpu.assessmentAndAlerting.domain.Notice;
import com.swpu.assessmentAndAlerting.service.INoticeService;

/**
 * 通知Service业务层处理
 * 
 * @author liushuang
 * @date 2024-02-02
 */
@Service
public class NoticeServiceImpl implements INoticeService 
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询通知
     * 
     * @param noticeId 通知主键
     * @return 通知
     */
    @Override
    public Notice selectNoticeByNoticeId(Integer noticeId)
    {
        return noticeMapper.selectNoticeByNoticeId(noticeId);
    }

    /**
     * 查询通知列表
     * 
     * @param notice 通知
     * @return 通知
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增通知
     * 
     * @param notice 通知
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改通知
     * 
     * @param notice 通知
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 批量删除通知
     * 
     * @param noticeIds 需要删除的通知主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByNoticeIds(Integer[] noticeIds)
    {
        return noticeMapper.deleteNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除通知信息
     * 
     * @param noticeId 通知主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByNoticeId(Integer noticeId)
    {
        return noticeMapper.deleteNoticeByNoticeId(noticeId);
    }
}
