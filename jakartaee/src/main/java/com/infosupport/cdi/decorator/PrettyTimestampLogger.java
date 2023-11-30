package com.infosupport.cdi.decorator;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDate;

@Decorator
public abstract class PrettyTimestampLogger implements Logger {
    @Inject @Delegate
    Logger logger;

    @Override
    public void log(String message) {
        logger.log("[%s] - %s".formatted(new PrettyTime().format(LocalDate.of(-20_000, 4, 22)), message));
    }
}
