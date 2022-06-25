package com.myth.hrmanage.dto;

import lombok.Data;

@Data
public class LoginTo {
    private String loginname;
    private String password;
    private Integer modules;
}
