package com.training.springcore;

import com.training.springcore.service.CaptorService;
import com.training.springcore.service.CaptorServiceImpl;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BigCorpApplicationConfig {

    @Bean (name="siteService")
    public SiteService siteService() {
        return new SiteServiceImpl(captorService());
    }

    @Bean (name="captorService")
    public CaptorService captorService() {
        return new CaptorServiceImpl();
    }
}
