package com.hamitmizrak.security;

import com.hamitmizrak.bean.PasswordEncoderBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//lombok
@RequiredArgsConstructor

//Security
@EnableWebSecurity
@Configuration
public class SecurityConfigurationCustom extends WebSecurityConfigurerAdapter {

    // field
    private final PasswordEncoderBean passwordEncoderBean;
    private final UserDetailsServiceCustom userDetailsServiceCustom;

    // Bean
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")//localhost
                 .allowedMethods("*"); //Get,Post etc çalışması
            }
        };
    }

    // Bean
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Override ++++++++++++++++++++++++
    //Kimlik doğrulama
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceCustom).passwordEncoder(passwordEncoderBean.passwordEncoderMethod());
    }

    //yetkilendirme yapılmışsa ilgili kullanıcının rolüne erişmesini sağlamaması için
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //session kullanmadığımız durumlarda(session yerine JWT kullanacağım)
        //Cross Side Request Forgery
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers("/api/authentication/**").permitAll().anyRequest().authenticated();
    }

    //web security
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
