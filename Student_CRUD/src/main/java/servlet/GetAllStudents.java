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
 * Servlet implementation class GetAllStudents
 */
@WebServlet("/GetAllStudents")
public class GetAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStudents() {
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
		
		List<Student> students = new ArrayList<>();
		
		try {
			students = studentDAO.getAllStudents();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		printWriter.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "  <head>\r\n"
				+ "    <title>Get All Students</title>\r\n"
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
				+ "        width: 80%;\r\n"
				+ "        padding: 10px;\r\n"
				+ "        text-align: center;\r\n"
				+ "        margin-top: 5%;\r\n"
				+ "        border-radius: 15px;\r\n"
				+ "        color: rgb(255, 255, 255);\r\n"
				+ "        background: hsla(120, 1%, 34%, 0.5);\r\n"
				+ "      }\r\n"
				+ "      .tab {\r\n"
				+ "        padding: 5px;\r\n"
				+ "        margin: 5px;\r\n"
				+ "        border-color: antiquewhite;\r\n"
				+ "      }\r\n"
				+ "      .tab, th, tr, td {\r\n"
				+ "        border: 2px solid white;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "<div>\r\n"
				+ "      <form action=\"StudentFrontEndServlet\">\r\n"
				+ "        <input type=\"submit\" name=\"Submit\" value=\"&#x2190\" style=\"width: 80px; height: 50px; font-size: 36px; font-weight: bold; background-color: #fff9a3; \">\r\n"
				+ "      </form>\r\n"
				+ "    </div>"
				+ "    <div class=\"section\">\r\n"
				+ "        <table class=\"tab\">\r\n"
				+ "            <tr>\r\n"
				+ "                <th>Id</th>\r\n"
				+ "                <th>Roll Number</th>\r\n"
				+ "                <th>Name</th>\r\n"
				+ "                <th>Father Name</th>\r\n"
				+ "                <th>Email</th>\r\n"
				+ "                <th>Age</th>\r\n"
				+ "                <th>Gender</th>\r\n"
				+ "                <th>Department Name</th>\r\n"
				+ "                <th>Date Of Birth</th>\r\n"
				+ "                <th colspan=2>Action</th>\r\n"
				+ "            </tr>\r\n");
				for(Student student : students) {
					printWriter.write("<tr>\r\n"
				+ "                <td>"+student.getId()+"</td><td>"+student.getRollNumber()+"</td><td>"+student.getName()+"</td><td>"+student.getFatherName()+"</td><td>"+student.getEmail()+"</td><td>"+student.getAge()+"</td><td>"+student.getGender()+"</td><td>"+student.getDepartmentName()+"</td><td>"+student.getDateOfBirth()+
				"</td><td><a href='UpdateServlet?action=UPDATE&studentId="+student.getId()+"'>Edit</a></td>"
				+ "<td><a href='DeleteServlet?action=DELETE&studentId="+student.getId()+"'>Delete</a></td>\r\n"
				+ "            </tr>\r\n");
				}
				
				printWriter.write("</table>\r\n"
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
