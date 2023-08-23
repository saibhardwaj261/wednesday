
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		try {
			int rows=RegisterDao.insertData(name, email, userName, password);
			if(rows>0)
			{
			    RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req,resp);
			}
			else
			{
				  RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			        rd.include(req, resp);
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

