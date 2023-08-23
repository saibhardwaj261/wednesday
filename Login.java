
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Log")
public class Log extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	String userName=req.getParameter("userName");
	String password=req.getParameter("password");
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	try {
		ResultSet rs=LoginDao.getData(userName, password);
		if(rs.next())
		{
		
		    RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
		rd.forward(req,resp);
		}
		else
		{

		 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.include(req,resp);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
