package com.myth.hrmanage.dao;

import com.github.aidensuen.mongo.pagehelper.PageInfo;
import com.myth.hrmanage.entity.Document;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Document)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
public interface DocumentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Document queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param document 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Document> queryAllByLimit(Document document, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param document 查询条件
     * @return 总行数
     */
    long count(Document document);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int insert(Document document);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Document> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Document> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Document> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Document> entities);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<Document> selectAll(String content);

}

