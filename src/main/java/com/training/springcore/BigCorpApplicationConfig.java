package com.training.springcore;


import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Set;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class BigCorpApplicationConfig {

    @Autowired
    private Environment environment;
    /*ApplicationInfo app;
    String name;
    Integer version;
    Set<String> emails;
    String webSiteUrl;*/

    @Bean
    public ApplicationInfo applicationInfo() {
        String name = environment.getRequiredProperty("bigcorp.name");
        Integer version = environment.getRequiredProperty("bigcorp.version", Integer.class);
        Set<String> emails = environment.getRequiredProperty("bigcorp.emails", Set.class);
        String webSiteUrl = environment.getRequiredProperty("bigcorp.webSiteUrl");
        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }

}
