package com.maihb.general.framework.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maihb.general.framework.filter.CustomCorsFilter;
import com.maihb.general.framework.filter.LoginFilter;
import com.maihb.general.framework.filter.SecurityFilter;
import com.maihb.general.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

/**
 * @author simon.wei
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    GeneralService generalService;

    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterRegistrationBean customCorsFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CustomCorsFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean loginFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LoginFilter(generalService));
        registrationBean.setUrlPatterns(Arrays.asList("/login"));
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean securityFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SecurityFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/login")
//                .authenticated()
                .anyRequest()
                .permitAll();
//                .and()
//                .formLogin()
//                .loginPage("/web/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();

    }
}
