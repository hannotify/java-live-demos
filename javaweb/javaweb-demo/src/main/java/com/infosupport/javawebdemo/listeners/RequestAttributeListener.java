package com.infosupport.javawebdemo.listeners;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.printf("-- Request Attribute was added: %s / %s%n", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.printf("-- Request Attribute was removed: %s / %s%n", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.printf("-- Request Attribute was replaced: %s / %s%n", srae.getName(), srae.getValue());
    }
}
