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
import maventest.entity.UserSn;

@WebServlet("/ShowAllUsers")
public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserSnDAO dao;
	//private UserSn userSn;
	private List<UserSn> users;
       
    public ShowAllUsers() {
        super();
        this.dao = new UserSnDAO();
        this.users = new ArrayList<UserSn>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		users = dao.showAllUsers();
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/userSn/usersListView.jsp");
		request.setAttribute("usersList", users);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
