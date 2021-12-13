package com.daresasuke.blog.service.impl;

import com.daresasuke.blog.entity.Blog;
import com.daresasuke.blog.dao.BlogDao;
import com.daresasuke.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Blog)表服务实现类
 *
 * @author makejava
 * @since 2021-10-31 18:15:06
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Blog queryById(Integer id) {
        return this.blogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Blog> queryAllByLimit(int offset, int limit) {
        return this.blogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog insert(Blog blog) {
        this.blogDao.insert(blog);
        return blog;
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog update(Blog blog) {
        this.blogDao.update(blog);
        return this.queryById(blog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.blogDao.deleteById(id) > 0;
    }

    @Override
    public List<Blog> queryAll() {
        return this.blogDao.queryAll();
    }
}