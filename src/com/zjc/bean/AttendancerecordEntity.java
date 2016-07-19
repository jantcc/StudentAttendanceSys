package com.zjc.bean;

public class AttendancerecordEntity {
int attendanceRecord_id;
int attendance_id;
int student_id;
String attendance_status;
public int getAttendanceRecord_id() {
	return attendanceRecord_id;
}
public void setAttendanceRecord_id(int attendanceRecord_id) {
	this.attendanceRecord_id = attendanceRecord_id;
}
public int getAttendance_id() {
	return attendance_id;
}
public void setAttendance_id(int attendance_id) {
	this.attendance_id = attendance_id;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getAttendance_status() {
	return attendance_status;
}
public void setAttendance_status(String attendance_status) {
	this.attendance_status = attendance_status;
}
}
