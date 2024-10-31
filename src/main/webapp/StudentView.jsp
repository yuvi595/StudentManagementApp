<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Student"%>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" type="text/css" href="studentview.css">
</head>
<body>
<a href="home.html">Home</a>

   
<br>
    <!-- Main Content -->
    <div class="container">
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
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) {
                for (Student student : students) {
            %>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getDOB()%></td>
                <td><%=student.getPhone()%></td>
                <td><%=student.getEmail()%></td>
                <td><%=student.getAddress()%></td>
                <td><%=student.getDept()%></td>
                <td><%=student.getPassout()%></td>
                <td><%=student.getCreatorid()%></td>
                <td>
                    <form action="delete" method="POST">
                        <input type="hidden" name="id" value="<%=student.getId()%>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
                <td>
                    <form action="edit" method="GET">
                        <input type="hidden" name="id" value="<%=student.getId()%>">
                        <input type="submit" value="Edit">
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
    </div>
</body>
</html>
