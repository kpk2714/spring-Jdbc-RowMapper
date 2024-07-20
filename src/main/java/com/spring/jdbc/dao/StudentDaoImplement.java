package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentdaoimplement")
public class StudentDaoImplement implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		
		 String query = "insert into student(id,name,city) values(?,?,?)";
		 int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		 return r;
	}
	
	public int change(Student student) {
		String query = "update student set name=?,city=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	public int delete(int StudentId) {
		String query = "delete from student where id= ?";
		int r = this.jdbcTemplate.update(query,StudentId);
		return r;
	}
	
	public Student getStudent(int StudentId) {
		
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper , StudentId);
		return student;
	}

	public List<Student> getAllStudent() {
		String query="select * from student";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		List<Student> student = this.jdbcTemplate.query(query,rowMapper);
		return student;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
