package com.myth.hrmanage.service.impl;

import com.myth.hrmanage.entity.Job;
import com.myth.hrmanage.dao.JobDao;
import com.myth.hrmanage.service.JobService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2022-06-22 14:26:18
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobDao jobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Job queryById(Integer id) {
        return this.jobDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param job         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Job> queryByPage(Job job, PageRequest pageRequest) {
        long total = this.jobDao.count(job);
        return new PageImpl<>(this.jobDao.queryAllByLimit(job, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job insert(Job job) {
        this.jobDao.insert(job);
        return job;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job update(Job job) {
        this.jobDao.update(job);
        return this.queryById(job.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobDao.deleteById(id) > 0;
    }
}
