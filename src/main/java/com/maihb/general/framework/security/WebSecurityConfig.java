package com.maihb.general.framework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author simon.wei
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    GeneralService generalService;

    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public FilterRegistrationBean customCorsFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new CustomCorsFilter());
//        registrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean loginFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new LoginFilter(generalService));
//        registrationBean.setUrlPatterns(Arrays.asList("/login"));
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean securityFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new SecurityFilter());
//        registrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return registrationBean;
//    }

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
