package com.maihb.general.controller;

import com.maihb.general.framework.web.ReturnValue;
import com.maihb.general.framework.wechat.WxUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WechatMessageController extends BaseController{

    @RequestMapping(path = "/selectWechatSign", method = RequestMethod.POST)
    public ReturnValue selectWechatSign(String url){
        return ReturnValue.success(WxUtil.getSign(url));
    }

}
