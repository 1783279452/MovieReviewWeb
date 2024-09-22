package com.example.moviereviewweb.service;


import com.example.moviereviewweb.Bean.Category;
import com.example.moviereviewweb.mapper.CategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Resource
  private CategoryMapper categoryMapper;

    /**
     *新增
     */
      public void add(Category category) {
          categoryMapper.insert(category);
      }
    /**
     *更新
     */
    public void update(Category category) {
        categoryMapper.updateById(category);
    }
    /**
     *删除
     */
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }
    /**
     * 查询所有
     */
    public List<Category> selectAll(Category category){
        return categoryMapper.selectAll(category);
    }
    /**
     * 分页查询
     * @param pageNum 当前的页码
     * @param pageSize 每页的个数
     * @return 分页的对象 包括数据和分页参数 total
     */
  public PageInfo<Category> selectPage(Category category,Integer pageNum, Integer pageSize) {
      PageHelper.startPage(pageNum, pageSize);
      List<Category> list = categoryMapper.selectAll(category);
      return PageInfo.of(list);
  }


}
