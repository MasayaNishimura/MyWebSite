package survlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyDao;
import dao.BuyDetailDao;
import dao.UserDao;
import model.Item;
import model.User;

/**
 * Servlet implementation class BuyResult
 */
@WebServlet("/BuyResult")
public class BuyResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> itemList = (ArrayList<Item>) session.getAttribute("cartInItem");
		User us = (User) session.getAttribute("userInfo");
		String loginId = us.getLoginId();
		UserDao ud = new UserDao();
		int userId = ud.findUserIdByLoginId(loginId);
		int totalPrice = (int) session.getAttribute("totalPrice");
		BuyDao bd = new BuyDao();
		int buyId = 0;
		try {
			buyId = bd.insertBuy(userId, totalPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BuyDetailDao bdd = new BuyDetailDao();
		try {
			bdd.insertBuyDetail(userId, buyId, itemList);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.removeAttribute("cartInItem");
		session.removeAttribute("totalPrice");
		session.removeAttribute("totalNum");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/buy_result.jsp");
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
