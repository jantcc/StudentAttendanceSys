package com.zjc.dao;

import com.zjc.bean.StudentEntity;

public interface StudentEntityDAO {
	public String login(int id,String pwd);
	public StudentEntity[] queryStudentEntityById(int id);
	public StudentEntity[] queryStudentEntityByName(String name);
	public StudentEntity[] queryStudentEntityByMajor(String major);
	public StudentEntity[] queryStudentEntityByClass(int classId);
	public int updateStudentPwd(int id,String oldPwd, String newPwd);
	public int updateStudentEmail(int id,String email);
	public String getpwd(int id);
	
	
	
}
