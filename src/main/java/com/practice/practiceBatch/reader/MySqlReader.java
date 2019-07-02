package com.practice.practiceBatch.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.practice.practiceBatch.exception.BatchException;
import com.practice.practiceBatch.model.read.StudentObj;

@Repository
@Transactional
@Service
public class MySqlReader {

	private DataSource dataSource;
	private Connection conn = null;

	public MySqlReader() {

		dataSource = DataSourceBuilder.create().username("root").password("root")
				.url("jdbc:mysql://127.0.0.1:3306/student?autoReconnect=true&useSSL=false")
				.driverClassName("com.mysql.jdbc.Driver").build();

		System.out.println("Datasource::" + dataSource);

	}

	public List<StudentObj> findAllStudents() throws BatchException {
		List<StudentObj> students = new ArrayList<StudentObj>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select * from student;";
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				rowmapper(students, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BatchException();
		}
		return students;
	}

	private void rowmapper(List<StudentObj> students, ResultSet rs) throws SQLException {
		StudentObj student = new StudentObj();
		student.setRollNo(rs.getInt("rollNo"));
		student.setName(rs.getString("name"));
		students.add(student);
	}
}
