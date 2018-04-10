package com.maihb.general.framework.wechat;

import lombok.Data;

@Data
public class TokenJson {

    private String accessToken;
    private int expiresIn;

}
