package com.myth.hrmanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.hrmanage.entity.Document;
import com.myth.hrmanage.dao.DocumentDao;
import com.myth.hrmanage.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Document)表服务实现类
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Resource
    private DocumentDao documentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Document queryById(Integer id) {
        return this.documentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param document    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Document> queryByPage(Document document, PageRequest pageRequest) {
        long total = this.documentDao.count(document);
        return new PageImpl<>(this.documentDao.queryAllByLimit(document, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document insert(Document document) throws IOException {
        saveFile(document);

        String path="F://data//temp";
        String fileName=document.getFile().getOriginalFilename();
        document.setFilename(fileName);
        document.setPath(path);
        document.setCreateDate(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
        documentDao.insert(document);
        return document;
    }

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document update(Document document) {
        this.documentDao.update(document);
        return this.queryById(document.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.documentDao.deleteById(id) > 0;
    }

    @Override
    public Integer count() {
        return Math.toIntExact(documentDao.count(new Document()));
    }

    @Override
    public void saveFile(Document document) throws IOException {
        String path="F://data//temp";
        String fileName=document.getFile().getOriginalFilename();
        File tempFile=new File(path+File.separator+fileName);
        tempFile.createNewFile();
        document.getFile().transferTo(tempFile);
    }

    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize, String content) {
        PageHelper.startPage(pageNum,pageSize);
        List<Document> documentList=documentDao.selectAll(content);
        PageInfo pageInfo=new PageInfo(documentList);
        return pageInfo;
    }
}
