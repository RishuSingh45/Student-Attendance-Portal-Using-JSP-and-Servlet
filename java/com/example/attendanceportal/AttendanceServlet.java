package com.example.attendanceportal;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date; // Important: use java.sql.Date

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// The URL pattern MUST match the form's 'action' attribute
@WebServlet("/markAttendance")
public class AttendanceServlet extends HttpServlet {

    // --- Database Connection Details ---
    // !! Replace with your database details !!
    private static final String DB_URL = "jdbc:mysql://localhost:3306/students_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@Ravi181910"; // TODO: Change this

    // Load the JDBC driver once when the servlet is initialized
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Failed to load JDBC driver", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get data from the JSP form
        String studentId = request.getParameter("studentId");
        String dateStr = request.getParameter("date"); // Gets date as "YYYY-MM-DD" string
        String status = request.getParameter("status");

        // 2. Prepare database query
        String sql = "INSERT INTO attendance (student_id, attendance_date, status) VALUES (?, ?, ?)";

        // 3. Use try-with-resources to automatically close the connection and statement
        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            // Convert the String date to java.sql.Date
            Date sqlDate = Date.valueOf(dateStr);

            // Set parameters for the PreparedStatement
            // This prevents SQL Injection attacks
            pstmt.setString(1, studentId);
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, status);

            // 4. Execute the query
            int rowsAffected = pstmt.executeUpdate();

            // 5. Send a response back to the user
            if (rowsAffected > 0) {
                // Success! Redirect to a success page.
                response.sendRedirect("success.jsp");
            } else {
                // This shouldn't happen with a simple insert, but good to have
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException e) {
            // Handle database errors
            // e.g., if we violate the UNIQUE constraint (duplicate entry)
            e.printStackTrace(); // Log the error
            response.sendRedirect("error.jsp");
        }
    }
}