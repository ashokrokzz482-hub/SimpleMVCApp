package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();

        // Remove cookie
        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        out.println("<h2>You are logged out successfully.</h2>");
        out.println("<a href='login.html'>Login again</a>");
    }
}
