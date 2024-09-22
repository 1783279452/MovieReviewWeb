package com.example.moviereviewweb.service;

import cn.hutool.core.date.DateUtil;
import com.example.moviereviewweb.Bean.Notice;
import com.example.moviereviewweb.mapper.NoticeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

  @Resource
  private NoticeMapper noticeMapper;

    /**
     *新增
     */
      public void add(Notice notice) {
          notice.setTime(DateUtil.now());//获取当前最新时间的字符串 设置到notice对象中去
          noticeMapper.insert(notice);
      }
    /**
     *更新
     */
    public void update(Notice notice) {
        noticeMapper.updateById(notice);
    }
    /**
     *删除
     */
    public void deleteById(Integer id) {
        noticeMapper.deleteById(id);
    }
    /**
     * 查询所有
     */
    public List<Notice> selectAll(Notice notice){
        return noticeMapper.selectAll(notice);
    }
    /**
     * 分页查询
     * @param pageNum 当前的页码
     * @param pageSize 每页的个数
     * @return 分页的对象 包括数据和分页参数 total
     */
  public PageInfo<Notice> selectPage(Notice notice,Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum, pageSize);
      List<Notice> list = noticeMapper.selectAll(notice);
      return PageInfo.of(list);
  }


}
