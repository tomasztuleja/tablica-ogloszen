package com.ttuleja.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

/**
 * Created by Tomal on 2017-06-14.
 */

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    /**
     * Metoda obsługująca logowanie użytkownika
     * @param auth objekt autentykacyjny
     * @throws Exception wyjątek np. dla braku użytkownika o następujących danych
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_name,user_password, user_status FROM user WHERE user_name=?")
                .authoritiesByUsernameQuery("SELECT user_name, user_role FROM user WHERE user_name=?")
                .passwordEncoder(passwordEncoder());
    }

    /**
     * Metoda konfigurująca dostęp w Spring Security
     * @param http obiekt klasy HttpSecurity
     * @throws Exception wyjątek
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/item/*", "/user/register")
                .permitAll()

                .antMatchers("/admin", "/admin/*")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

    /**
     * Metoda pozwalająca na integracje Thymeleaf z Spring Security
     * @return
     */
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    /**
     * Metoda szyfrująca hasło
     * @return zaszyfrowane hasło
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


}
