package slider;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/slider", "root", "12341234");
		PreparedStatement ps=con.prepareStatement("insert into sign values(?,?,?,?)");
		String a=request.getParameter("txt");
		String b=request.getParameter("email");
		String c=request.getParameter("pswd");
		String d=request.getParameter("par");
		PrintWriter out=response.getWriter();
		ps.setString(1, a);
		ps.setString(2, b);
		ps.setString(3, c);
		ps.setString(4, d);
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			out.println("updated");
	
		}
		else
			out.println("not updated");
		con.close();
		}
		 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
