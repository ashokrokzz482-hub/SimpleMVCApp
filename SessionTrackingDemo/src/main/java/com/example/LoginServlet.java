package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("uname");

        // --- Using Cookies ---
        Cookie cookie = new Cookie("username", name);
        response.addCookie(cookie);

        // --- Using HttpSession ---
        HttpSession session = request.getSession();
        session.setAttribute("user", name);

        out.println("<h2>Welcome " + name + "</h2>");
        out.println("<a href='welcome'>Go to Welcome Page</a>");
    }
}
