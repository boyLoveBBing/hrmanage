package com.myth.hrmanage.service;

import com.github.pagehelper.PageInfo;
import com.myth.hrmanage.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
public interface DocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Document queryById(Integer id);

    /**
     * 分页查询
     *
     * @param document    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Document> queryByPage(Document document, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document insert(Document document) throws IOException;

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer count();

    PageInfo selectAll(Integer pageNum, Integer pageSize, String content);

    void saveFile(Document document) throws IOException;
}
