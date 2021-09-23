package messageboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class MessageBoardServlet
 */
public class MessageBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MessageBoardServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = request.getParameter("text");
		String uid = (String) request.getSession().getAttribute("uid");
		String update = request.getParameter("update");
		MessageBoardService service = new MessageBoardService();
		if (msg != null) {
			service.newMessage(uid, msg);
			String message = "新增成功";
			request.setAttribute("message", message);
			request.getRequestDispatcher("MessageBoard.jsp").forward(request, response);
		} else {
			if(update != null) {
				int index = (Integer)request.getSession().getAttribute("index");
				service.updateMessage(index, update);
				String message = "修改成功";
				request.setAttribute("message", message);
				request.getRequestDispatcher("MessageBoard.jsp").forward(request, response);
			} else
				doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = (String) request.getSession().getAttribute("uid");
		int bt = Integer.valueOf(request.getParameter("bt"));
		MessageBoardService service = new MessageBoardService();
		if (bt == 1 ) {
			ArrayList<MessageBoard> list = service.getAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("AllMessage.jsp").forward(request, response);
		} else if (bt == 2)
			request.getRequestDispatcher("NewMessage.jsp").forward(request, response);
		else if (bt == 3) {
			int index = Integer.valueOf(request.getParameter("index"));
			index = service.selectSerial(index);
			
			request.setAttribute("index", index);
			request.getRequestDispatcher("UpdateMessage.jsp").forward(request, response);
		} else if (bt == 4) {
			int index = Integer.valueOf(request.getParameter("index"));
			service.deleteMessage(index);
			String message = "已刪除";
			request.setAttribute("message", message);
			request.getRequestDispatcher("MessageBoard.jsp").forward(request, response);
		}
	}

}
