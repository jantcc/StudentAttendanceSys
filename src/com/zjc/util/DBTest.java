package com.zjc.util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection(); // ������Ӷ���
		String querySQL = "SELECT * FROM studentinfo";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySQL); // ���������, ִ�в�ѯ
			while(rs.next()){
				String id=rs.getString("student_id");
				String name=rs.getString("student_name");
				System.out.println("student_id:"+id+"-----student_name:"+name);
			}
			

			DatabaseConnection.close(rs); // �رս����
			DatabaseConnection.close(stmt); // �ر�Ԥ�������
			DatabaseConnection.close(conn); // �ر����Ӷ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
