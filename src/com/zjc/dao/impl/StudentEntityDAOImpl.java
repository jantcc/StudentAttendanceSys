package com.zjc.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zjc.bean.StudentEntity;
import com.zjc.dao.StudentEntityDAO;
import com.zjc.util.DatabaseConnection;

public class StudentEntityDAOImpl implements StudentEntityDAO {

	@Override
	public String login(int id, String pwd) {
		// TODO 自动生成的方法存根
		Connection conn = DatabaseConnection.getConnection();
		String querySQL = "SELECT * FROM studentinfo WHERE student_id =? AND student_login_pwd=?";
		String stuName=null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(querySQL);
			pstmt.setInt(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				stuName=rs.getString("student_name");
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(pstmt);
			DatabaseConnection.close(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stuName;
	}

	@Override
	public StudentEntity[] queryStudentEntityById(int id) {
	
		
		return null;
	}

	@Override
	public StudentEntity[] queryStudentEntityByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StudentEntity[] queryStudentEntityByMajor(String major) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StudentEntity[] queryStudentEntityByClass(int classId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateStudentPwd(int id, String oldPwd, String newPwd) {
		// TODO 自动生成的方法存根
		Connection conn = DatabaseConnection.getConnection();
		String querySQL = "select *from studentinfo where student_id = " + id + " and student_login_pwd = " + "'"+oldPwd+"'";
		String updateSQL = " update studentinfo set student_login_pwd = " + "'"+newPwd+"'" + "where student_id = " + id;
		int returnVal = -1;
		try{
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySQL);
			
			if(rs.next()){
				returnVal = stmt.executeUpdate(updateSQL);
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch(Exception e){
			e.printStackTrace();
		}
		return returnVal;
	}

	@Override
	public int updateStudentEmail(int id, String email) {
		// TODO 自动生成的方法存根
		Connection conn = DatabaseConnection.getConnection();
		String querySQL = "select *from studentinfo where student_id = '"+ id +"'";
		String updateSQL = " update studentinfo set student_email = '"+ email +"' where student_id = '"+ id +"' " ;
		int returnVal = -1;
		try{
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySQL);
			
			if(rs.next()){
				returnVal = stmt.executeUpdate(updateSQL);
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch(Exception e){
			e.printStackTrace();
		}
		return returnVal;
		
	}

	@Override
	public String getpwd(int id) {
		// TODO 自动生成的方法存根
		Connection conn = DatabaseConnection.getConnection();
		String querySQL = "SELECT * FROM studentinfo WHERE student_id =?";
		String stuid=null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(querySQL);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				stuid=rs.getString("student_login_pwd").trim();
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(pstmt);
			DatabaseConnection.close(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stuid;
	}
	
	
	}
	