package servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import daoimpl.*;
import model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		
		String rollNumber = request.getParameter("rollNumber");
		String name = request.getParameter("name");
		String fatherName = request.getParameter("fatherName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String dateOfBirth = request.getParameter("dateOfBirth");
		
		
		StudentDAO studentDAO = new StudentDAOImp();
		Student student = new Student();
		student.setRollNumber(rollNumber);
		student.setName(name);
		student.setFatherName(fatherName);
		student.setAge(age);
		student.setEmail(email);
		student.setDepartmentName(department);
		student.setDateOfBirth(dateOfBirth);
		student.setGender(gender);
		
		
		
		try {
			studentDAO.addStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		printWriter.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <title>Student Form</title>\r\n"
				+ "    <style>\r\n"
				+ "\r\n"
				+ "      body{\r\n"
				+ "        font-size: 24px;\r\n"
				+ "        background-image: linear-gradient(30deg, red,rgb(21, 0, 104),blue,rgb(9, 147, 221),violet);\r\n"
				+ "        background-attachment: fixed;\r\n"
				+ "        \r\n"
				+ "      }\r\n"
				+ "      .section{\r\n"
				+ "        border: 5px;\r\n"
				+ "        margin: auto;\r\n"
				+ "        width: 50%;\r\n"
				+ "        padding: 10px;\r\n"
				+ "        text-align: center;\r\n"
				+ "        margin-top: 10%;\r\n"
				+ "        border-radius: 15px;\r\n"
				+ "        color: rgb(255, 255, 255);\r\n"
				+ "        background: hsla(120, 1%, 34%, 0.5);\r\n"
				+ "      }\r\n"
				+ "      .btn{\r\n"
				+ "        width: 50%;\r\n"
				+ "        height: 40px;\r\n"
				+ "        background-color: #BBE3FF;\r\n"
				+ "        font-size: larger;\r\n"
				+ "        font-weight: bold;\r\n"
				+ "        font-family: 'Times New Roman', Times, serif;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    \r\n"
				+ "    \r\n"+"<div>\r\n"
				+ "      <form action=\"StudentFrontEndServlet\">\r\n"
				+ "        <input type=\"submit\" name=\"Submit\" value=\"&#x2190\" style=\"width: 80px; height: 50px; font-size: 36px; font-weight: bold; background-color: #fff9a3; \">\r\n"
				+ "      </form>\r\n"	
				+ "    </div>"
				+ "    <div class=\"section\">\r\n"
				+ "        <h1>Data Successfully Submitted</h1>\r\n"
				+ "        \r\n"
				+ "        <form action=\"GetAllStudents\">\r\n"
				+ "            <input type=\"submit\" value=\"Get All Students\" name=\"submit\" class=\"btn\">\r\n"
				+ "        </form>\r\n"
				+ "        \r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
