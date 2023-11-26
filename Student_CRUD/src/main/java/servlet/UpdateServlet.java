package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StudentDAO;
import daoimpl.StudentDAOImp;
import model.Student;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		StudentDAO studentDAO = new StudentDAOImp();
		Student student = new Student();
		
		String action = request.getParameter("action");

		System.out.println(action);
			try {
			if("UPDATE".equals(action)) {
				int studentId = Integer.parseInt(request.getParameter("studentId"));

				
				 student = studentDAO.getStudentById(studentId);

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
					+ "        margin-top: 50px;\r\n"
					+ "        border-radius: 15px;\r\n"
					+ "        color: rgb(255, 255, 255);\r\n"
					+ "        background: hsla(120, 1%, 34%, 0.5);\r\n"
					+ "      \r\n"
					+ "      }\r\n"
					+ "      input{\r\n"
					+ "        height: 30px;\r\n"
					+ "        width: 30%;\r\n"
					+ "        background-color: rgb(240, 239, 239);\r\n"
					+ "        margin: 20px;\r\n"
					+ "        border-radius: 10px;\r\n"
					+ "      }\r\n"
					+ "      select{\r\n"
					+ "        width: 240px;\r\n"
					+ "        height: 35px;\r\n"
					+ "        background-color: rgb(240, 239, 239);\r\n"
					+ "      }\r\n"
					+ "      .gender{\r\n"
					+ "        margin-right: 46px;\r\n"
					+ "      }\r\n"
					+ "      .radio{\r\n"
					+ "        height: 20px;\r\n"
					+ "        width: 20px;       \r\n"
					+ "      }\r\n"
					+ "      .email{\r\n"
					+ "        margin-left: 30px;\r\n"
					+ "      }\r\n"
					+ "      .age{\r\n"
					+ "        margin-left: 10px;\r\n"
					+ "      }\r\n"
					+ "      .department{\r\n"
					+ "        margin-right: 30px;\r\n"
					+ "      }\r\n"
					+ "      .combobox{\r\n"
					+ "        border: 1px solid #E5E5E5;\r\n"
					+ "        border-radius: 5px 5px 5px 5px;\r\n"
					+ "      }\r\n"
					+ "      .dob{\r\n"
					+ "        margin-left: 15px;\r\n"
					+ "      }\r\n"
					+ "      .inputdob{\r\n"
					+ "        height: 35px;\r\n"
					+ "      }\r\n"
					+ "      .submit{\r\n"
					+ "        width: 40%;\r\n"
					+ "        height: 40px;\r\n"
					+ "        background-color: blanchedalmond;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "    </style>\r\n"
					+ "  </head>\r\n"
					+ "  <body>\r\n"
					+ "    \r\n"
					+ "    \r\n"
					+ "    <div class=\"section\">\r\n"
					+ "      <h1>Student Registration Form</h1>\r\n"
					+ "      <form action=\"\" class=\"form\" method=\"POST\">\r\n"
					+ "        <label>Roll Number</label> <input type=\"text\" name=\"rollNumber\" value="+student.getRollNumber()+">\r\n"
					+ "        <label>Name</label><input type=\"text\" name=\"name\" value="+student.getName()+"><br><br>\r\n"
					+ "        <label>Father Name</label><input type=\"text\" name=\"fatherName\" value="+student.getFatherName()+">\r\n"
					+ "        <label class=\"age\">Age</label> <input type=\"number\" name=\"age\" value="+student.getAge()+"><br><br>\r\n"
					+ "        <label class=\"gender\">Gender</label>\r\n"
					+ "          <input type=\"radio\" class=\"radio\" name=\"studentgender\" value=\"Male\">Male\r\n"
					+ "          <input type=\"radio\" class=\"radio\" name=\"studentgender\" value=\"Female\">Female \r\n"
					+ "        \r\n"
					+ "        <label class=\"email\">Email</label> <input type=\"email\" name=\"email\" value="+student.getEmail()+"><br><br>\r\n"
					+ "        <label class=\"department\">Department</label>\r\n"
					+ "        <select name=\"departmentName\" id=\"combobox\" value="+student.getDepartmentName()+">\r\n"
					+ "          <option value=\"\" disabled selected>--Select Department--</option>\r\n"
					
					 
					 + "          <option value=\"BS Computer Science\">BS Computer Science</option>\r\n"
					 + "          <option value=\"BE Computer System\">BE Computer System</option>\r\n"
					 + "          <option value=\"BE Telecommunication\">BE Telecommunication</option>\r\n"
					 + "          <option value=\"City Regional Planning\">City Regional Planning</option>\r\n"
					 + "          <option value=\"Electronics Engineering\">Electronics Engineering</option>\r\n"
					 + "          <option value=\"Electrical Engineering\">Electrical Engineering</option>\r\n"
					 + "          <option value=\"Software Engineering\">Software Engineering</option>\r\n");
					 
					printWriter.write("</select>\r\n"
					+ "        <label class=\"dob\">DOB</label>\r\n"
					+ "        <input type=\"date\" class=\"inputdob\" name=\"dateOfBirth\" value="+student.getDateOfBirth()+">\r\n"
					+ "        <input type=\"submit\" class=\"submit\">\r\n"
					+ "      </form>\r\n"
					+ "    </div>\r\n"
					+ "  </body>\r\n"
					+ "</html>");
		
		
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				Student student1 = new Student();
			try {
				int id = Integer.parseInt(request.getParameter("studentId"));
				String rollNumber = request.getParameter("rollNumber");
				String name = request.getParameter("name");
				String fatherName = request.getParameter("fatherName");
				String email = request.getParameter("email");
				String age = request.getParameter("age");
				String gender = request.getParameter("studentgender");
				String departmentName = request.getParameter("departmentName");
				String dob = request.getParameter("dateOfBirth");
				
				student1.setId(id);
				student1.setRollNumber(rollNumber); 
				student1.setName(name);
				student1.setFatherName(fatherName); 
				student1.setEmail(email);
				student1.setAge(Integer.parseInt(age));
				student1.setGender(gender); 
				student1.setDepartmentName(departmentName);
				student1.setDateOfBirth(dob);
								 
				boolean success = studentDAO.updateStudent(student1);
				
				if(success) {
					String contextPath = request.getContextPath();
					response.sendRedirect(contextPath+"/GetAllStudents");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
			
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
