package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // --- Retrieve Cookie ---
        String userFromCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    userFromCookie = c.getValue();
                }
            }
        }

        // --- Retrieve from Session ---
        HttpSession session = request.getSession(false); // don't create new
        String userFromSession = (session != null) ? (String) session.getAttribute("user") : null;

        if (userFromCookie != null && userFromSession != null) {
            out.println("<h2>Welcome back, " + userFromSession + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h2>Please login first!</h2>");
            out.println("<a href='login.html'>Go to Login</a>");
        }
    }
}
