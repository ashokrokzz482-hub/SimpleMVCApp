<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List - MVC Example</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th><th>Name</th><th>Course</th>
        </tr>
        <%
            java.util.List<com.example.mvc.model.Student> students =
                (java.util.List<com.example.mvc.model.Student>) request.getAttribute("students");

            if (students != null) {
                for (com.example.mvc.model.Student s : students) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getCourse() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
