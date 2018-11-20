package maventest.web.userSn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.UserSnDAO;

@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSnDAO dao;
       
    public DeleteUser() {
    	this.dao = new UserSnDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteUserById(id);
		response.sendRedirect("ShowAllUsers");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
