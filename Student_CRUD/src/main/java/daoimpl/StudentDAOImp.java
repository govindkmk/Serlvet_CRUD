package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import dbconnection.DbConnection;
import model.Student;

public class StudentDAOImp implements StudentDAO {
	
	
	private final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT(roll_number, name, father_name, age, email, department_name, dob, gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?); "; 
	private final String UPDATE_STUDENT_QUERY = "UPDATE STUDENT SET roll_number = ?, name = ?, father_name = ?, age = ?, email = ?, department_name = ?, dob = ?, gender = ? WHERE id = ?; ";
	private final String GET_STUDENT_BY_ID_QUERY = "SELECT roll_number, name, father_name, age, email, department_name, dob, gender FROM STUDENT WHERE id = ?; ";
	private final String GETALL_STUDENT_QUERY = "SELECT * FROM STUDENT; ";
	private final String DELETE_STUDENT_QUERY = "DELETE FROM STUDENT WHERE id = ?; ";
	
	public void addStudent(Student student) throws SQLException {
		Connection connection = DbConnection.getConnection();
		
		
		PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT_QUERY);
		
		
		ps.setString(1, student.getRollNumber());
		ps.setString(2, student.getName());
		ps.setString(3, student.getFatherName());
		ps.setInt(4, student.getAge());
		ps.setString(5, student.getEmail());
		ps.setString(6, student.getDepartmentName());
		ps.setString(7, student.getDateOfBirth());
		ps.setString(8, student.getGender());
		
		ps.execute();
		
		
		
		
	}
	
	public boolean updateStudent(Student student) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(UPDATE_STUDENT_QUERY);
		
		
		ps.setString(1, student.getRollNumber());
		ps.setString(2, student.getName());
		ps.setString(3, student.getFatherName());
		ps.setInt(4, student.getAge());
		ps.setString(5, student.getEmail());
		ps.setString(6, student.getDepartmentName());
		ps.setString(7, student.getDateOfBirth());
		ps.setString(8, student.getGender());
		ps.setInt(9, student.getId());
		
		ps.executeUpdate();
		
		return true;
		
	}	
	
	
	 public Student getStudentById(Integer id) throws SQLException { Connection
	 con = DbConnection.getConnection();
	 
	 PreparedStatement ps = con.prepareStatement(GET_STUDENT_BY_ID_QUERY);
	 ps.setInt(1, id);
	 ResultSet rst = ps.executeQuery();
	 
	 while(rst.next()) { 
		 Student student = new Student();
	 student.setRollNumber(rst.getString("roll_number"));
	 student.setName(rst.getString("name"));
	 student.setFatherName(rst.getString("father_name"));
	 student.setAge(rst.getInt("age"));
	 student.setEmail(rst.getString("email"));
	 student.setDepartmentName(rst.getString("department_name"));
	 student.setDateOfBirth(rst.getString("dob"));
	 student.setGender(rst.getString("gender"));
	 student.setId(id);
	 
	 
	 return student; 
	 }
	  
	 return null;
	 
	 }
	 
	
	
	public List<Student> getAllStudents() throws SQLException {
        Connection con = DbConnection.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rst = statement.executeQuery(GETALL_STUDENT_QUERY);
            // do not call a query in a loop
            while (rst.next()) {
                Student s = new Student();
                
                s.setId(rst.getInt("id"));
                s.setRollNumber(rst.getString("roll_number"));
                s.setName(rst.getString("name"));
                s.setFatherName(rst.getString("father_name"));
                s.setAge(rst.getInt("age"));
                s.setEmail(rst.getString("email"));
                s.setDepartmentName(rst.getString("department_name"));
                s.setDateOfBirth(rst.getString("dob"));
                s.setGender(rst.getString("gender"));
           
                
                students.add(s);
            }

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
	
	public void deleteStudent(Integer id) throws SQLException {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(DELETE_STUDENT_QUERY);
		
		ps.setInt(1, id);
		
		
		ps.executeUpdate();
		
		
		System.out.println("Student has been deleted successfully...");

	}

}
