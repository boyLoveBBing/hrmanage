package com.myth.hrmanage.dao;

import com.myth.hrmanage.entity.Job;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Job)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
public interface JobDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Job queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param job      查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Job> queryAllByLimit(Job job, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param job 查询条件
     * @return 总行数
     */
    long count(Job job);

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 影响行数
     */
    int insert(Job job);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Job> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Job> entities);

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 影响行数
     */
    int update(Job job);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

