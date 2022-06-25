package com.myth.hrmanage.entity;

import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2022-06-22 14:26:18
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -71606124807896475L;

    private Integer id;

    private String title;

    private String content;

    private String createdate;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

