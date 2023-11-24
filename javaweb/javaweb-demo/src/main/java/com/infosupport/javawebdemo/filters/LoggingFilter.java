package com.infosupport.javawebdemo.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, filterName = "loggingFilter")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("- LoggingFilter: sending request to servlet... -");

        chain.doFilter(request, response);

        System.out.println("- LoggingFilter: sending response to client... -");
    }
}
