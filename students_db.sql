-- Create a database if you don't have one
CREATE DATABASE IF NOT EXISTS students_db;

-- Use the database
USE students_db;

-- Create the attendance table
CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(50) NOT NULL,
    attendance_date DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    -- Add a unique constraint to prevent duplicate entries for the same student on the same day
    UNIQUE KEY uk_student_date (student_id, attendance_date)
);
