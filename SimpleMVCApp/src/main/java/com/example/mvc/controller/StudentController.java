package com.example.mvc.controller;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.mvc.model.Student;

@WebServlet("/students")
public class StudentController extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Create sample data (In real case, this comes from DB)
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Ashok", "CSE"));
        studentList.add(new Student(2, "Ravi", "ECE"));
        studentList.add(new Student(3, "Vinay", "IT"));

        // Store list in request scope
        request.setAttribute("students", studentList);

        // Forward to the JSP (View)
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }
}
