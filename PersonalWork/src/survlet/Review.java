package survlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDao;
import dao.ReviewDao;
import model.Item;
import model.User;

/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int itemId = Integer.parseInt(request.getParameter("id"));
		Item item = new ItemDao().findItemById(itemId);
		session.setAttribute("item", item);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/review.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		User us = (User) session.getAttribute("userInfo");
		int userId = us.getId();
		int itemId = Integer.parseInt(request.getParameter("id"));
		String review = request.getParameter("review");
		String star = request.getParameter("rating");
		try {
			new ReviewDao().insertReview(userId, itemId, review, star);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("UserInfo");
	}

}
