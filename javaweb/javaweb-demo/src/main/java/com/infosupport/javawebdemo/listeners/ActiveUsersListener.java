package com.infosupport.javawebdemo.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveUsersListener implements HttpSessionListener {
    private final AtomicInteger counter = new AtomicInteger(0);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        var count = counter.incrementAndGet();
        System.out.printf("Active users: %d%n", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        var count = counter.decrementAndGet();
        System.out.printf("Active users: %d%n", count);
    }
}
