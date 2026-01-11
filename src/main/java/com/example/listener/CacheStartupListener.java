package com.example.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import com.example.cache.ReferenceCache;
import com.example.util.CacheKeys;


@WebListener
public class CacheStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext ctx = event.getServletContext();
        System.out.println("Starting application...");

        try {
            Map<String, String> cache = ReferenceCache.load();
            ctx.setAttribute(CacheKeys.REFERENCE_CACHE, cache);
            ctx.setAttribute(CacheKeys.CACHE_READY, true);

            System.out.println("Cache loaded successfully");

        } catch (Exception e) {
            ctx.setAttribute(CacheKeys.CACHE_READY, false);
            throw new RuntimeException("Cache loading failed", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().removeAttribute(CacheKeys.REFERENCE_CACHE);
        System.out.println("Cache cleared");
    }
}

