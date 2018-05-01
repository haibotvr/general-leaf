package com.maihb.general.modules.entity;

import com.maihb.general.framework.abstracts.AbstractUser;
import lombok.Data;

import java.util.Date;

@Data
public class GeneralUser extends AbstractUser{

    private Long id;

    private String adminUsername;

    private String adminPassword;

    private String adminRealname;

    private Date createTime;

    private Integer adminStatus;

}
