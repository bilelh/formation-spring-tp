package com.training.springcore.service;

import com.training.springcore.config.BigCorpApplicationConfig;
import com.training.springcore.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service
public class SiteServiceImpl implements SiteService {

    private ResourceLoader resourceLoader;

    private CaptorService captorService;

    public SiteServiceImpl() {
    }

    @Autowired
    public SiteServiceImpl(CaptorService captorService,ResourceLoader resourceLoader) {
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
        this.resourceLoader = resourceLoader;
    }

    @BigCorpApplicationConfig.Monitored
    @Override
    public Site findById(String siteId) {
        System.out.println("Appel de findById :" + this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }

    @Override
    public void readFile(String path) {
        Resource resource = resourceLoader
                .getResource(path);

        try (InputStream stream = resource.getInputStream()) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
