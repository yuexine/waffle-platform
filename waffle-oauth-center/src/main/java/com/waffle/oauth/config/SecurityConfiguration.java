package com.waffle.oauth.config;

import com.waffle.oauth.security.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * @author yuexin
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    public SecurityConfiguration() {
        System.out.println("SecurityConfiguration init");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf()
                    .disable()
                .formLogin()
                    .loginProcessingUrl("/login")
                    .and()
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        http
                .authorizeRequests()
                    .antMatchers("/resource/**").hasRole("USER")
                    .antMatchers("/client/user").permitAll()
                    .antMatchers("/client/**").hasAnyRole("MANAGER","CLIENT_USER")
                    .and()
                .requestMatchers()
                    .antMatchers("/resource/**", "/client/**", "/login", "logout")
                    .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO: ignore static files
        web
                .httpFirewall(allowUrlEncodedSlashHttpFirewall())
                .ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/webjars/**", "/**.{html,css,js,ico}", "/favicon.ico")
        ;
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        return firewall;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
