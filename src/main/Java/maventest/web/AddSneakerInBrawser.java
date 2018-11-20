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

@WebServlet("/AddSneakerInBrawser")
public class AddSneakerInBrawser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddSneakerInBrawser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/sneakers/createSneakerView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SneakersDAO dao = null;
		try {
			dao = new SneakersDAO();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

		String brand = (String) request.getParameter("brand");
		String model = (String) request.getParameter("model");
		String description = (String) request.getParameter("description");
		//System.out.println(model);
		int releaseYear = Integer.parseInt(request.getParameter("release_year"));

		Sneaker sneaker = new Sneaker(brand, model, releaseYear, description);

		try {
			dao.saveSneaker(sneaker);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("sneaker", sneaker);
		response.sendRedirect("SneakerList");
	}

}
