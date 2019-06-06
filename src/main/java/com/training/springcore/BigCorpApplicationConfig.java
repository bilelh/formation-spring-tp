package com.training.springcore;


import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class BigCorpApplicationConfig {
    ApplicationInfo app;

    @Value("${bigcorp.name}")
    String name;
    @Value("${bigcorp.version}")
    Integer version;
    @Value("${bigcorp.emails}")
    Set<String> emails;
    @Value("${bigcorp.webSiteUrl}")
    String webSiteUrl;

    @Bean
    public ApplicationInfo applicationInfo() {
        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }

}
