package com.myth.hrmanage.service;

import com.myth.hrmanage.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Recruit)表服务接口
 *
 * @author makejava
 * @since 2022-06-22 14:26:18
 */
public interface RecruitService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recruit queryById(Integer id);

    /**
     * 分页查询
     *
     * @param recruit     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Recruit> queryByPage(Recruit recruit, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param recruit 实例对象
     * @return 实例对象
     */
    Recruit insert(Recruit recruit);

    /**
     * 修改数据
     *
     * @param recruit 实例对象
     * @return 实例对象
     */
    Recruit update(Recruit recruit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
