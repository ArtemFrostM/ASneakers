package maventest.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maventest.dao.entity.SneakersDAO;
import maventest.entity.Sneaker;

@WebServlet("/SneakerList")
public class SneakerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Sneaker sneaker;
       
    public SneakerList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SneakersDAO dao = new SneakersDAO();
			
			List<Sneaker> sneakers = dao.showAllSneakers();
			
			request.setAttribute("sneakerList", sneakers);
			
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/sneakers/sneakersListView.jsp");
	        dispatcher.forward(request, response);
			
			PrintWriter writer = response.getWriter();
			
			//System.out.println(request.getParameter("model"));
			
			writer.append(sneakers.toString());
			//response.addHeader("Authorization", "sadsdasdasdasdasd");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
