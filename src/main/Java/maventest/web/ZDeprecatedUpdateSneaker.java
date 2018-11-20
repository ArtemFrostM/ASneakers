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

@WebServlet("/UpdateSneaker")
public class ZDeprecatedUpdateSneaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ZDeprecatedUpdateSneaker() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SneakersDAO dao = new SneakersDAO();
			Sneaker sneaker = new Sneaker("Y3", "Running Flue 3.0", 2001, "For your personal running records");
			dao.updateSneaker(sneaker, 7);
			
			List<Sneaker> sneakers = dao.showAllSneakers();
			
			PrintWriter writter = response.getWriter();
			
			writter.append(sneakers.toString());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
