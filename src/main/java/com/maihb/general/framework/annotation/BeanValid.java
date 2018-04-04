package com.maihb.general.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeanValid {

    //是否必须校验
    boolean required() default true;

}
