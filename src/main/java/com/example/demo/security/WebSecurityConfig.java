package com.example.demo.security;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.support.LoginSuccessHandler;
import com.example.demo.support.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    // Code3----------------------------------------------
    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserDetailsService();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();

    }
    //http://localhost:8080/login 输入正确的用户名密码 并且选中remember-me 则登陆成功，转到 index页面
    //再次访问index页面无需登录直接访问
    //访问http://localhost:8080/home 不拦截，直接访问，
    //访问http://localhost:8080/hello 需要登录验证后，且具备 “ADMIN”权限hasAuthority("ADMIN")才可以访问
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)//在正确的位置添加我们自定义的过滤器
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()
                //.antMatchers("/hello").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                .rememberMe()
                .tokenValiditySeconds(1209600);
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //指定密码加密所使用的加密器为passwordEncoder()
    //需要将密码加密后写入数据库
      //  auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
        auth.userDetailsService(customUserService());
    //不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }



}
