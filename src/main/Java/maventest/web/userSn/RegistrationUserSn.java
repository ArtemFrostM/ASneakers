package maventest.web.userSn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.UserSnDAO;
import maventest.entity.Sneaker;
import maventest.entity.UserSn;

@WebServlet("/registration")
public class RegistrationUserSn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSnDAO dao;
       
    public RegistrationUserSn() {
        super();
        this.dao = new UserSnDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/userSn/userRegistrationView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserSn userSn = new UserSn(nickname, firstName, lastName, password, email);
		dao.createUser(userSn);
		
		request.setAttribute("userSn", userSn);
		response.sendRedirect("SneakerList");
	}

}
