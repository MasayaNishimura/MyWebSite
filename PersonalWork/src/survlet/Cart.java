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
import model.Item;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Item> itemList;
		if (session.getAttribute("cartInItem") == null) {
			itemList = new ArrayList<Item>();
		} else {
			itemList = (ArrayList<Item>) session.getAttribute("cartInItem");
		}
		if (request.getParameter("add") != null) {
			int id = Integer.parseInt(request.getParameter("add"));
			int itemNum = Integer.parseInt(request.getParameter("itemNum"));
			if (itemNum < 1) {
				request.setAttribute("errMsg", "商品は1つ以上選択してください");
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/add_cart.jsp");
				dispatcher.forward(request, response);
				return;
			}
			ItemDao itemDao = new ItemDao();
			Item item = itemDao.findItemById(id);
			boolean flag = false;
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getId() == item.getId()) {
					itemList.get(i).plusNum(itemNum);
					flag = true;
				}
			}
			if (!flag) {
				item.plusNum(itemNum);
				itemList.add(item);
			}
		}

		if (request.getParameter("delete") != null) {
			int id = Integer.parseInt(request.getParameter("delete"));
			if (itemList.get(id).getOverLappedNum() == 1) {
				itemList.remove(id);
			} else {
				itemList.get(id).minusNum();
			}
		}
		if (request.getParameter("emptyCart") != null) {
			itemList.clear();
		}

		session.setAttribute("cartInItem", itemList);

		int totalNum = 0;
		for (int i = 0; i < itemList.size(); i++) {
			totalNum += itemList.get(i).getOverLappedNum();
		}
		session.setAttribute("totalNum", totalNum);

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect("/PersonalWork/Login");
			return;
		}

		if (request.getParameter("buy") != null && itemList.size() != 0) {
			int totalPrice = 0;
			for (int i = 0; i < itemList.size(); i++) {
				totalPrice += itemList.get(i).getPrice() * itemList.get(i).getOverLappedNum();
			}
			session.setAttribute("totalPrice", totalPrice);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/buy_confirm.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (request.getParameter("buy") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/cart.jsp");
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/cart.jsp");
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
