package com.students.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.students.model.Student;
import com.students.util.DbUtil;

public class StudentRepository {
	private Connection dbConnection;

	public StudentRepository() {
		dbConnection = DbUtil.getConnection();
	}

	public void register(String username, String password, String email) throws SQLException {
		PreparedStatement prepStatement = null;
		try {
			prepStatement = dbConnection.prepareStatement(
					"insert into student(username, email, password) values (?, ?, ?)");
			prepStatement.setString(1, username);
			prepStatement.setString(2, email);
			prepStatement.setString(3, password);
			
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Student> getRecords() {
		Statement statement = null;
		List<Student> list = new ArrayList<>();
		try {
			statement = dbConnection.createStatement();
			ResultSet result = statement.executeQuery("select username, email from student;");
			if (result != null) {
				while (result.next()) {
					list.add(new Student(result.getString(1), result.getString(2)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
