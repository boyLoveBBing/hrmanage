package com.myth.hrmanage.service.impl;

import com.myth.hrmanage.entity.Recruit;
import com.myth.hrmanage.dao.RecruitDao;
import com.myth.hrmanage.service.RecruitService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Recruit)表服务实现类
 *
 * @author makejava
 * @since 2022-06-22 14:26:18
 */
@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Recruit queryById(Integer id) {
        return this.recruitDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param recruit     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Recruit> queryByPage(Recruit recruit, PageRequest pageRequest) {
        long total = this.recruitDao.count(recruit);
        return new PageImpl<>(this.recruitDao.queryAllByLimit(recruit, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param recruit 实例对象
     * @return 实例对象
     */
    @Override
    public Recruit insert(Recruit recruit) {
        this.recruitDao.insert(recruit);
        return recruit;
    }

    /**
     * 修改数据
     *
     * @param recruit 实例对象
     * @return 实例对象
     */
    @Override
    public Recruit update(Recruit recruit) {
        this.recruitDao.update(recruit);
        return this.queryById(recruit.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.recruitDao.deleteById(id) > 0;
    }
}
