
# Student Attendance Portal

A Java-based web application that allows users to mark student attendance and store attendance records in a MySQL database.

## About the Project

The Student Attendance Portal is developed using Java, JSP, Jakarta Servlets, JDBC, and MySQL. It provides a simple interface to submit student attendance details and saves them in a database.

## Features

- Mark student attendance.
- Enter Student ID and attendance date.
- Select attendance status (Present or Absent).
- Store attendance records in MySQL.
- Prevent duplicate attendance entries for the same student on the same date.
- Display success and error messages.

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Jakarta Servlets
- JDBC
- MySQL
- Maven
- Apache Tomcat 11

## Project Structure

```text
Student-Attendance-Portal/
│
├── java/
│   └── com/example/attendanceportal/
│       └── AttendanceServlet.java
│
├── index.jsp
├── success.jsp
├── error.jsp
├── students_db.sql
├── pom.xml
└── README.md
```

## Database Setup

1. Open MySQL.
2. Execute the `students_db.sql` file.
3. The script creates the `students_db` database.
4. It also creates the `attendance` table.

The attendance table stores:
- ID
- Student ID
- Attendance Date
- Attendance Status

## How to Run the Project

1. Install JDK 24, Maven, MySQL, and Apache Tomcat 11.
2. Clone the repository:

```bash
git clone https://github.com/RishuSingh45/Student-Attendance-Portal-Using-JSP-and-Servlet.git
```

3. Open the project in IntelliJ IDEA or Eclipse.
4. Configure your MySQL database connection securely.
5. Build the project:

```bash
mvn clean package
```

6. Deploy the generated WAR file from the `target` folder to Tomcat 11.
7. Start the Tomcat server and open:

```text
http://localhost:8080/AttendancePortal-1.0-SNAPSHOT/
```

## Project Workflow

1. User opens the attendance form.
2. User enters the Student ID and attendance date.
3. User selects Present or Absent.
4. The servlet receives the submitted information.
5. JDBC connects to MySQL and inserts the attendance record.
6. The application displays the result.

## Screenshots

Add actual screenshots of your project here:

- Attendance Form
- Successful Attendance Submission
- Error Message

## Project Repository

GitHub: https://github.com/RishuSingh45/Student-Attendance-Portal-Using-JSP-and-Servlet

## Live Demo

Not deployed yet. The application can be run locally using Apache Tomcat and MySQL.

## Author

**Rishu Kumar**

Computer Science Engineering Student
