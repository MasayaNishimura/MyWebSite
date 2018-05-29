package survlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDao;
import dao.UserDao;
import model.Item;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(loginId, password);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (user == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット

		HttpSession session = request.getSession();
		user = userDao.userInfoDetail(loginId);
		session.setAttribute("userInfo", user);

		if (session.getAttribute("cartInItem") != null) {
			List<Item> itemList = (ArrayList<Item>) session.getAttribute("cartInItem");
			if (itemList.size() != 0) {
				response.sendRedirect("/PersonalWork/Cart");
				return;
			}
		}

		// ユーザ一覧のサーブレットにリダイレクト
		ItemDao id = new ItemDao();
		List<Item> randomItemList = id.randomItemList();
		request.setAttribute("randomItemList", randomItemList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
		dispatcher.forward(request, response);
	}

}
