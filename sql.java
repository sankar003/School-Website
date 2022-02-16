package slider;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sql extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String  name=request.getParameter("name");
		String  word=request.getParameter("pswd");
		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/slider", "root", "12341234");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from sign");
		while (rs.next()) {
			String a=rs.getString(1);
			String b=rs.getString(3);
				if(a.equals(name) && b.equals(word))
				{
					//out.print("true");
					response.sendRedirect("grade.html");
				}
				else{
					out.print("false");
				}
			
				
		}
		con.close();
		}
				 catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}
