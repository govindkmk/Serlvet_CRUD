package dao;

import java.sql.SQLException;
import java.util.List;

import model.Student;

public interface StudentDAO {
	
	void addStudent(Student student)throws SQLException;
	boolean updateStudent(Student student) throws SQLException;
	Student getStudentById(Integer id) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
	void deleteStudent(Integer id) throws SQLException;

}
