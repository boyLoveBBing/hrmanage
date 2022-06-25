package com.myth.hrmanage.service.impl;

import com.myth.hrmanage.entity.Dept;
import com.myth.hrmanage.dao.DeptDao;
import com.myth.hrmanage.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Dept)表服务实现类
 *
 * @author makejava
 * @since 2022-06-22 14:26:16
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Integer id) {
        return this.deptDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dept        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Dept> queryByPage(Dept dept, PageRequest pageRequest) {
        long total = this.deptDao.count(dept);
        return new PageImpl<>(this.deptDao.queryAllByLimit(dept, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept insert(Dept dept) {
        this.deptDao.insert(dept);
        return dept;
    }

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept update(Dept dept) {
        this.deptDao.update(dept);
        return this.queryById(dept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.deptDao.deleteById(id) > 0;
    }

    @Override
    public Integer count() {
        return Math.toIntExact(deptDao.count(new Dept()));
    }
}
