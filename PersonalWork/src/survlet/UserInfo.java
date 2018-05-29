package survlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyDao;
import dao.UserDao;
import model.Buy;
import model.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("userInfo");
		UserDao usd = new UserDao();
		us = usd.userInfoDetail(us.getLoginId());
		session.setAttribute("userInfoDetail", us);
		int userId = usd.findUserIdByLoginId(us.getLoginId());
		BuyDao bd = new BuyDao();
		List<Buy> buyList = null;
		try {
			buyList = bd.buyHistory(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.setAttribute("buyHistory", buyList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user_info.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
