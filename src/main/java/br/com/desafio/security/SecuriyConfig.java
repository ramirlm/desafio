package br.com.desafio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ramir on 20/01/2017.
 */
@Configuration
@EnableWebSecurity
public class SecuriyConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/showVersion").permitAll();
                //.anyRequest().authenticated();

        http.csrf().disable().httpBasic();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("piupiu").password("piupiu").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("piupiu2").password("piupiu2").roles("USER");
    }



}


@RestController
@PropertySource("classpath:application.properties")
class WebApplication {
    @Value("${api.version}")
    private String apiVersion;

    @RequestMapping("/showVersion")
    public String showVersion(Authentication authentication) {
        String msg = "";
        if(authentication != null){
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority();
                msg+= authentication.getName()+", You have "+ role;
            }
            return apiVersion +" - User :"+msg;

        }else{
            return apiVersion + " - Anonymous User";
        }
    }

}
