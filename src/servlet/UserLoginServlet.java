package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		User user = new UserDAO().getUser(name, password);
		if(null!=user){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/cart/listProduct");
		}
		else{
			response.sendRedirect("/cart/login.jsp");
		}
	}
}
