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

@WebServlet("/user_s-sneakers")
public class UsersSneakers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSn userSn;
	private UserSnDAO dao;
	private List<Sneaker> sneakers;

	public UsersSneakers() {
		this.sneakers = new ArrayList<Sneaker>();
		this.dao = new UserSnDAO();
		this.userSn = new UserSn();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		userSn = dao.showUsersSneakers(id);
		request.setAttribute("userModel", userSn);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/userSn/userSneakersView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
