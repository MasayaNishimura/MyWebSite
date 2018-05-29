package survlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BrowsingHistoryDao;
import dao.ItemDao;
import dao.ReviewDao;
import model.Item;
import model.Review;
import model.User;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		if (session.getAttribute("userInfo") != null) {
			User us = (User) session.getAttribute("userInfo");
			new BrowsingHistoryDao().insertBrowsingHistory(us.getId(), id);
		}
		ItemDao itemDao = new ItemDao();
		Item item = itemDao.findItemById(id);
		session.setAttribute("item", item);
		ReviewDao rd = new ReviewDao();
		List<Review> reviewList = rd.createReviewList(id);
		session.setAttribute("reviewList", reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/add_cart.jsp");
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
