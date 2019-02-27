package com.mtx.config;

import com.mtx.extend.security.JwtAuthenticationFilter;
import com.mtx.extend.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//// step1
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth)
////            throws Exception{
////        auth.inMemoryAuthentication().withUser("user1")
////                .password("{noop}password").roles("REGISTERED_USER");
////    }
////
////    protected void configure(HttpSecurity http) throws Exception{
////        http.csrf().disable()
////                .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin();
////    }
//
//
// step2
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception{
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        auth.inMemoryAuthentication().withUser("user1")
//                .password("{noop}password").roles("USER");
    }

    @Autowired
    public JwtAuthenticationFilter jwtAuthenticationFilter;


        protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().addFilterAt(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers("/api/users/login","/api/user/login","/api/users/signup").permitAll().
                and()
                    .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER","ADMIN")
                .and()
                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .and()
//                formLogin();
    }


}