package maventest.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.SneakersDAO;
import maventest.entity.Sneaker;


@WebServlet("/show-profile")
public class ShowSneakerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowSneakerProfile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SneakersDAO dao;
		try {
			dao = new SneakersDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			Sneaker sneaker = dao.showOneSneakerById(id);
			request.setAttribute("sneakerModel", sneaker);
			request.getServletContext().getRequestDispatcher("/WEB-INF/views/sneakers/profileSneakerView.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
