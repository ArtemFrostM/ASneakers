package maventest.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.SneakersDAO;
import maventest.entity.Sneaker;

@WebServlet("/DeleteSneaker")
public class ZDeprecatedDeleteSneaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ZDeprecatedDeleteSneaker() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SneakersDAO dao = new SneakersDAO();
			dao.deleteSneaker(0);
			
			List<Sneaker> sneakers = dao.showAllSneakers();
			
			PrintWriter writer = response.getWriter();

			writer.append(sneakers.toString());
			//response.addHeader("Authorization", "sadsdasdasdasdasd");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
