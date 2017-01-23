package br.com.desafio.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@PropertySource("classpath:application.properties")
public class VersionService {
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