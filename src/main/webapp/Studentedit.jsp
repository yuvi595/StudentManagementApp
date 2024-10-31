<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.model.Student"%>

<%
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        out.println("Student not found.");
        return;
    }
%>

<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student Information</h2>
    <form action="edit" method="POST">
        <input type="hidden" name="id" value="<%= student.getId() %>">
        <label>Name:</label><input type="text" name="name" value="<%= student.getName() %>"><br>
        <label>DOB:</label><input type="text" name="dob" value="<%= student.getDOB() %>"><br>
        <label>Phone Number:</label><input type="text" name="phone" value="<%= student.getPhone() %>"><br>
        <label>Email:</label><input type="text" name="email" value="<%= student.getEmail() %>"><br>
        <label>Address:</label><input type="text" name="address" value="<%= student.getAddress() %>"><br>
        <label>Department:</label><input type="text" name="dept" value="<%= student.getDept() %>"><br>
        <label>Passout:</label><input type="text" name="passout" value="<%= student.getPassout() %>"><br>
        
        <input type="submit" value="Update">
    </form>
</body>
</html>
