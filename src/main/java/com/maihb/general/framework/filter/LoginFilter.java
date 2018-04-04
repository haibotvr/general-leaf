package com.maihb.general.framework.filter;

import com.maihb.general.framework.kits.JsonUtil;
import com.maihb.general.framework.security.LoginRequest;
import com.maihb.general.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆过滤器
 * @author simon.wei
 */
@Slf4j
public class LoginFilter extends OncePerRequestFilter {

    GeneralService generalService;

    public LoginFilter(GeneralService generalService) {
        this.generalService = generalService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        //接收认证参数
        LoginRequest loginRequest = JsonUtil.mapper.readValue(httpServletRequest.getReader(), LoginRequest.class);
        //登陆逻辑
        JsonUtil.mapper.writeValue(httpServletResponse.getWriter(), generalService.login(loginRequest));
    }
}
