package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");

        HttpSession session = req.getSession(true);
        session.setAttribute("user", username);

        resp.sendRedirect("dashboard");

    }
}
