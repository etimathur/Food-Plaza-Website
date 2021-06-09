package foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodplaza.dao.CartDaoImpl;
import foodplaza.dao.OrderDaoImpl;
import foodplaza.pojo.Order;
@WebServlet("/OrderServlet")
public class OrderSevlet extends HttpServlet{
	
	String email;
	boolean flag;
	OrderDaoImpl odao=new OrderDaoImpl();
	CartDaoImpl cdao=new CartDaoImpl();
	List<Order> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		email=(String)session.getAttribute("user");
		String action = req.getParameter("action");
		if(action.equals(null))
		{
		doPost(req, resp);
		}
		else if(action!=null && action.equals("allorders"))
		{
			List<Order> list=odao.showOrder(email);
			req.setAttribute("allOrder", list);
			req.getRequestDispatcher("OrderList.jsp").forward(req, resp);
		}
		else if(action!=null && action.equals("admin"))
		{
			List<Order> list=odao.showAllOrder();
			req.setAttribute("allOrder", list);
			req.getRequestDispatcher("OrderList.jsp").forward(req, resp);
		}
		else if(action!=null && action.equals("place"))
		{
			flag=odao.placeOrder(email);
			if(flag)
			{
				flag=cdao.clearCart(email);
				if(flag)
				{
					list=odao.showOrder(email);
					session.setAttribute("orderList", list.get(list.size()-1));
					resp.sendRedirect("OrderDetails.jsp");
				}
				else
				{
					resp.sendRedirect("Fail.jsp");
				}
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
	
	}
	

}
