package com.maihb.general.framework.security;

import com.maihb.general.framework.web.ReturnValue;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class LeafErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> resultMap = super.getErrorAttributes(requestAttributes, includeStackTrace);
        resultMap.put("code", ReturnValue.error().getCode());
        resultMap.put("success", false);
        return resultMap;
    }
}
