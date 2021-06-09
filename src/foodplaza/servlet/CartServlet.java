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
import foodplaza.dao.FoodDaoImpl;
import foodplaza.pojo.Cart;
import foodplaza.pojo.Food;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	CartDaoImpl cdao=new CartDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("user");
		String action=(String)req.getParameter("action");
		if(action!=null && action.equals("add") )
		{
		int foodId=Integer.parseInt(req.getParameter("fid"));
		FoodDaoImpl fdao=new FoodDaoImpl();
		Food food=fdao.searchFoodById(foodId);
		if(food!=null)
		{
			session.setAttribute("food", food);
			resp.sendRedirect("AddToCart.jsp");
		}
		else
		{
			resp.sendRedirect("Fail.jsp");
		}
		}
		else if(action!=null && action.equals("mycart"))
		{
			
			List<Cart> list=cdao.showCart(user);
			System.out.println(list);
			session.setAttribute("list", list);
			resp.sendRedirect("CartList.jsp");
		}
		else if(action!=null && action.equals("delete"))
		{
			int id=Integer.parseInt(req.getParameter("cartid"));
			if(cdao.deleteCart(id))
			{
				resp.sendRedirect("Successfull.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
	
		else if(action!=null && action.equals("clear"))
		{
			if(cdao.clearCart(user))
			{
				session.setAttribute("list", null);
				resp.sendRedirect("Successfull.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int foodId=Integer.parseInt(req.getParameter("fid"));
		int foodQuantity=Integer.parseInt(req.getParameter("fquan"));
		double foodPrice=Double.parseDouble(req.getParameter("fprice"));
		String foodName=req.getParameter("fname");
		String custEmail=req.getParameter("email");
		
		Cart cart=new Cart(foodId,foodQuantity,custEmail,foodName,foodPrice);
		CartDaoImpl cdao=new CartDaoImpl();
		boolean flag=cdao.addToCart(cart);
		if(flag)
		{
			resp.sendRedirect("index.jsp");
		}
		else
			resp.sendRedirect("Fail.jsp");
		
	}
}
