package login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		LoginService service = new LoginService();
		int result = service.checkLogin(uid, pwd);
		if (result == 1) {
			request.setAttribute("message", "�n�J���\");
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MessageBoard.jsp").forward(request, response);
		} else {
			if (result == 2) {
				request.setAttribute("message", "�K�X���~");
			} else {
				request.setAttribute("message", "�L���b��");
			}
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
