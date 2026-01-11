package com.example.servlet;

import com.example.util.CacheKeys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String> cache =
                (Map<String, String>) getServletContext().getAttribute(CacheKeys.REFERENCE_CACHE);

        req.setAttribute("roles", cache);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
