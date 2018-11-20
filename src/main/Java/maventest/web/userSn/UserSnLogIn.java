package maventest.web.userSn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vaventest.dao.validator.UserValidator;


@WebServlet("/log-in")
public class UserSnLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserValidator validator;
       
 
    public UserSnLogIn() {
    	this.validator = new UserValidator();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
