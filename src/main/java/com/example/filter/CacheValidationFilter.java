package com.example.filter;

import com.example.util.CacheKeys;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CacheValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        ServletContext ctx = request.getServletContext();
        Boolean ready = (Boolean) ctx.getAttribute(CacheKeys.CACHE_READY);

        if (ready == null || !ready)
        {
            ((HttpServletResponse) response).
                    sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Application is initializing");
            return;
        }

        chain.doFilter(request, response);
    }
}
