<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Attendance Portal</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { border: 1px solid #ccc; padding: 20px; border-radius: 8px; }
        div { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; }
        input[type="text"], input[type="date"], select { padding: 8px; width: 200px; }
        input[type="submit"] { padding: 10px 20px; background-color: #007bff; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>

<h2>Mark Student Attendance</h2>

<form action="markAttendance" method="POST">
    <div>
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required>
    </div>
    <div>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>
    </div>
    <div>
        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select>
    </div>
    <div>
        <input type="submit" value="Submit Attendance">
    </div>
</form>

</body>
</html>