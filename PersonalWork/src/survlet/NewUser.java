package survlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/new_user.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String loginId = request.getParameter("loginId");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		UserDao ud = new UserDao();
		if (ud.isOverlapped(loginId)) {
			request.setAttribute("errMsg", "ログインIDはすでに使われています");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/new_user.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if (!password.equals(passwordConfirm)) {
			request.setAttribute("errMsg", "パスワードが異なります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/new_user.jsp");
			dispatcher.forward(request, response);
			return;
		}

		ud.insertNewUser(loginId, name, birthDate, password);

		User user = new User(loginId, password);
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);

		response.sendRedirect("/PersonalWork");

	}

}
