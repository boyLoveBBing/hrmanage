package com.myth.hrmanage.service;

import com.myth.hrmanage.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Job)表服务接口
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
public interface JobService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Job queryById(Integer id);

    /**
     * 分页查询
     *
     * @param job         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Job> queryByPage(Job job, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    Job insert(Job job);

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    Job update(Job job);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
