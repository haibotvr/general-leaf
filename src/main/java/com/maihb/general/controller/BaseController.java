package com.maihb.general.controller;

import com.maihb.general.entity.GeneralUser;
import com.maihb.general.framework.kits.LeafConstant;
import com.maihb.general.framework.kits.JsonUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author simon.wei
 */
public class BaseController {

    HttpServletRequest request;

    HttpServletResponse response;

    HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    GeneralUser getUser(){
        return JsonUtil.toBean(session.getAttribute(LeafConstant.SESSION_USER).toString(), GeneralUser.class);
    }

}
