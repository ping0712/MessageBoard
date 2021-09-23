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
			request.setAttribute("message", "登入成功");
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MessageBoard.jsp").forward(request, response);
		} else {
			if (result == 2) {
				request.setAttribute("message", "密碼錯誤");
			} else {
				request.setAttribute("message", "無此帳號");
			}
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
