package maventest.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.SneakersDAO;
import maventest.entity.Sneaker;

@WebServlet("/AddSneaker")
public class ZDeprecatedAddSneaker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ZDeprecatedAddSneaker() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			SneakersDAO dao = new SneakersDAO();
			Sneaker sneaker = new Sneaker("New Balance", "993", 1993,
					"Jesus they're cooler than me!");
			dao.saveSneaker(sneaker);

			List<Sneaker> sneakers = dao.showAllSneakers();

			PrintWriter writer = response.getWriter();

			writer.append(sneakers.toString());
			response.addHeader("Authorization", "sadsdasdasdasdasd");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
