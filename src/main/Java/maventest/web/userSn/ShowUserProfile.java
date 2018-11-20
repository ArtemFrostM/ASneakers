package maventest.web.userSn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.UserSnDAO;
import maventest.entity.UserSn;

@WebServlet("/ShowUserProfile")
public class ShowUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSn userSn;
	private UserSnDAO dao;
       
    public ShowUserProfile() {
    	this.dao = new UserSnDAO();
    	this.userSn = new UserSn();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		userSn = dao.showOneUserById(id);
		request.setAttribute("userModel", userSn);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/userSn/userProfileView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
