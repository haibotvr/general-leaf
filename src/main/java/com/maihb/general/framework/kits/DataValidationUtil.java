package com.maihb.general.framework.kits;

import com.maihb.general.framework.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class DataValidationUtil {

    public static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static Validator validator = factory.getValidator();

    public static <T> void validate(T bean){
        StringBuffer sb = new StringBuffer();
        try {
            if(null == bean){
                sb.append("校验的对象不能为null");
            } else {
                Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean);
                for (ConstraintViolation<T> violation : constraintViolations) {
                    sb.append(violation.getPropertyPath()).append(":").append(violation.getMessage()).append(" ,");
                }
            }
        } catch (Exception e) {
            log.error("数据校验发生异常", e);
            throw new ValidException(sb.toString());
        }
        if(!StringUtils.isEmpty(sb.toString())){
            sb.append("数据校验发生异常，请检查字段注解配置是否合法");
            throw new ValidException(sb.toString());
        }
    }

}
