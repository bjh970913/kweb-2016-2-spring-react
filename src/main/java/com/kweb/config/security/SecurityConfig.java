package com.kweb.config.security;

import com.kweb.config.constant.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private SecurityUserAuthProvider securityUserAuthProvider;

    @Autowired
    public SecurityConfig(SecurityUserAuthProvider securityUserAuthProvider) {
        this.securityUserAuthProvider = securityUserAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityUserAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/join").anonymous()
                .antMatchers("/admin/**").hasAuthority(UserRoles.ROLE_ADMIN.toString())
                .antMatchers("/post/write").hasAnyAuthority(UserRoles.ROLE_USER.toString(), UserRoles.ROLE_ADMIN.toString())
                .anyRequest().permitAll()
                .and()
            .csrf().disable()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login_process")
                .defaultSuccessUrl("/main", true)
                .failureUrl("/login")
                .successHandler(new SecurityAuthSuccessHandler())
                .and()
            .logout()
                .logoutUrl("/logout").permitAll();
    }
}
