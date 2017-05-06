package com.security.configs;


import com.security.handlers.CustomAuthenticationSuccessHandler;
import com.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@ComponentScan("com")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        // отключена защита csrf на время тестов
        http.csrf().disable().addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyAuthority("USER")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/")
                .failureUrl("/?error")
                .successHandler(customAuthenticationSuccessHandler)
                .usernameParameter("username")
                .passwordParameter("password");

    }
}
