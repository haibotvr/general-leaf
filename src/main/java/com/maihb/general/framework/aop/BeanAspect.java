package com.maihb.general.framework.aop;

import com.maihb.general.framework.kits.DataValidationUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class BeanAspect {

    @Before("@annotation(com.maihb.general.framework.annotation.BeanValid)")
    public void checkBeanValid(JoinPoint joinPoint) throws Exception {
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        args.stream().forEach(obj -> {
            DataValidationUtil.validate(obj);
        });
    }
}
