package com.zjc.util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection(); // 获得连接对象
		String querySQL = "SELECT * FROM studentinfo";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySQL); // 声明结果集, 执行查询
			while(rs.next()){
				String id=rs.getString("student_id");
				String name=rs.getString("student_name");
				System.out.println("student_id:"+id+"-----student_name:"+name);
			}
			

			DatabaseConnection.close(rs); // 关闭结果集
			DatabaseConnection.close(stmt); // 关闭预处理对象
			DatabaseConnection.close(conn); // 关闭连接对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
