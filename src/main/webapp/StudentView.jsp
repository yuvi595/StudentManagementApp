<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Student"%>
<html>
<head>
<title>Student List</title>
<style>
table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid black;
    padding: 8px;
    text-align: left;
}
</style>
</head>
<body>
    <h2>Student List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Department</th>
            <th>Passout</th>
            <th>Creator ID</th>
        </tr>
        <%
        // Check if the students list is null or empty
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getDOB() %></td>
            <td><%= student.getPhone() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getAddress() %></td>
            <td><%= student.getDept() %></td>
            <td><%= student.getPassout() %></td>
            <td><%= student.getCreatorid() %></td>
            <td>
                <form action="delete" method="POST">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="10">No students found</td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
