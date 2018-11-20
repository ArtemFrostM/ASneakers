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

@WebServlet("/edit-my-profile")
public class EditUserSn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSnDAO dao;
	private UserSn userSn;
       
    public EditUserSn() {
        this.dao = new UserSnDAO();
        this.userSn = new UserSn();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		userSn = dao.showOneUserById(id);
		
		request.setAttribute("userModel", userSn);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/userSn/editUserView.jsp");
		dispatcher.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserSn sneaker = new UserSn(id, nickname, firstName, lastName, password, email);
		
		dao.editUser(sneaker, id);
		
		request.setAttribute("userModel", sneaker);
		
		response.sendRedirect("ShowAllUsers");
		
	}

}
