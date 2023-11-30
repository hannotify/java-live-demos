package com.infosupport.cdi.decorator;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class LoggerBean {
    @Inject Logger logger;

    @PostConstruct
    public void logAtStartup() {
        logger.log("LoggerBean created at startup, using Logger instance %s.".formatted(logger));
    }
}
