package com.zjc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver"; // ������
	private static final String DBURL = "jdbc:mysql://localhost:3306/stuattendance";// ����URL
	private static final String DBUSER = "root"; // �û���
	private static final String DBPASSWORD = "root"; // ���ݿ�����

	public static Connection getConnection() {
		Connection conn = null; // ����һ�����Ӷ���
		try {
			Class.forName(DBDRIVER); // ע������
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) { // ���conn ���Ӷ���Ϊ��
			try {
				conn.close(); // �ر�conn ���Ӷ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) { // ���pstmt Ԥ�������Ϊ��
			try {
				pstmt.close(); // �ر�pstmt Ԥ�������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) { // ���stmt �������Ϊ��
			try {
				stmt.close(); // �ر�stmt �������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) { // ���rs ���������Ϊnull
			try {
				rs.close(); // �ر�rs ���������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
