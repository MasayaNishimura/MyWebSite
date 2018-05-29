package survlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("product_search") != null) {
			int sPrice;
			int ePrice;
			String word;
			if (request.getParameter("sProductPrice").equals("") || Integer.parseInt(request.getParameter("sProductPrice")) < 0){
				sPrice = 0;
			} else {
				sPrice = Integer.parseInt(request.getParameter("sProductPrice"));
			}

			if (request.getParameter("eProductPrice").equals("") || Integer.parseInt(request.getParameter("eProductPrice")) < 0) {
				ePrice = 0;
			} else {
				ePrice = Integer.parseInt(request.getParameter("eProductPrice"));
			}

			if (request.getParameter("product_search").equals("")) {
				word = "";
			} else {
				word = request.getParameter("product_search");
			}
			ItemDao itemDao = new ItemDao();
			List<Item> referItemList = itemDao.referItemList(sPrice, ePrice, word);
			request.setAttribute("referItemList", referItemList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/search.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
