package com.maib.general;

import com.maihb.general.config.MainConfigOfAutowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @org.junit.Test
    public void test1(){
        printBeans(applicationContext);
        System.out.println("=========================");
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] defitationNames = applicationContext.getBeanDefinitionNames();
        for (String defitationName : defitationNames) {
            System.out.println(defitationName);
        }

    }

}
