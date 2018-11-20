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

@WebServlet("/editSneakers")
public class EditSneakers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditSneakers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SneakersDAO dao = null;
		
		try {
			dao = new SneakersDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		Sneaker sneaker = null;
		
		try {
			sneaker = dao.showOneSneakerById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		if (sneaker == null) {
            response.sendRedirect(request.getServletPath() + "/SneakerList");
            return;
        }
		
        request.setAttribute("sneaker", sneaker);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/sneakers/editSneakerView.jsp");
        dispatcher.forward(request, response);
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("release_year"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SneakersDAO dao = new SneakersDAO();
			
			String model = request.getParameter("model");
			String description = request.getParameter("description");
			int id = Integer.parseInt(request.getParameter("id"));
			int releaseYear = Integer.parseInt(request.getParameter("release_year"));
			String brand = request.getParameter("brand");
			
			Sneaker sneaker = new Sneaker(id, brand, model, releaseYear, description);
			
			System.out.println(sneaker);
			
			dao.updateSneaker(sneaker, id);
			
			request.setAttribute("sneaker", sneaker);
			
			response.sendRedirect("SneakerList");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
