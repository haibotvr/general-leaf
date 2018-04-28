package com.maihb.general.framework.security;

import com.maihb.general.framework.web.ReturnValue;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class LeafErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Map<String, Object> resultMap = super.getErrorAttributes(request, includeStackTrace);
        resultMap.put("code", ReturnValue.error().getCode());
        resultMap.put("success", false);
        return resultMap;
    }
}
