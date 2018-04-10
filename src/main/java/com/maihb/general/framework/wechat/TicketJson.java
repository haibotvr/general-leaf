package com.maihb.general.framework.wechat;

import lombok.Data;

@Data
public class TicketJson {

    private int errcode;
    private String errmsg;
    private String ticket;
    private String expiresIn;

}
