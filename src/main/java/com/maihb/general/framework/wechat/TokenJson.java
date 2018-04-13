package com.maihb.general.framework.wechat;

import lombok.Data;

@Data
public class TokenJson {

    private String access_token;
    private int expires_in;

}
