package com.myth.hrmanage.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Recruit)实体类
 *
 * @author makejava
 * @since 2022-06-22 14:26:18
 */
public class Recruit implements Serializable {
    private static final long serialVersionUID = 333749422323364493L;

    private Integer id;

    private Integer deptId;

    private Integer jobId;

    private Integer personNum;

    private String remark;
    /**
     * 审核状态
     */
    private String status;

    private Date createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

