package foodplaza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import foodplaza.dao.FoodDaoImpl;
import foodplaza.pojo.Food;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet{
	
	FoodDaoImpl fdao=new FoodDaoImpl();
	Food food;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String action=req.getParameter("method");
		HttpSession session=req.getSession();
		if(action==null)
		{
			
		FoodDaoImpl fdao=new FoodDaoImpl();
		List<Food> list=fdao.getAllFood();
		
		session.setAttribute("foodList", list);
		resp.sendRedirect("FoodList.jsp");
		}
		else if(action.equals("edit") && action!=null)
		{
			
			int fid=Integer.parseInt(req.getParameter("fid"));
			food=fdao.searchFoodById(fid);
			session.setAttribute("food",food);
			resp.sendRedirect("UpdateFood.jsp");
		}
		else if(action.equals("delete") && action!=null)
		{
			int fid=Integer.parseInt(req.getParameter("fid"));
			boolean flag=fdao.deleteFood(fid);
			if(flag)
			{
				
				resp.sendRedirect("Successfull.jsp");
			}
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if(action!=null && action.equals("search"))
		{
			System.out.println("Request from ajax");
			String type=req.getParameter("type");
			if(type!=null && type.equals("fname"))
			{
				String data=req.getParameter("data");
				List<Food> list=fdao.searchFoodByName(data);
				Gson j=new Gson();
				JsonElement je=j.toJsonTree(list);
				JsonArray ja=je.getAsJsonArray();
				resp.setContentType("aplication/json");
				resp.getWriter().print(ja);
			}
			else if(type!=null && type.equals("ftype"))
			{
				String data=req.getParameter("data");
				List<Food> list=fdao.searchFoodByType(data);
				Gson j=new Gson();
				JsonElement je=j.toJsonTree(list);
				JsonArray ja=je.getAsJsonArray();
				System.out.println(list);
				resp.setContentType("aplication/json");
				resp.getWriter().print(ja);
			}
			else if(type!=null && type.equals("fcat"))
			{
				String data=req.getParameter("data");
				List<Food> list=fdao.searchFoodByCategory(data);
				Gson j=new Gson();
				JsonElement je=j.toJsonTree(list);
				JsonArray ja=je.getAsJsonArray();
				resp.setContentType("aplication/json");
				resp.getWriter().print(ja);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String action=req.getParameter("action");
		PrintWriter pw=resp.getWriter();
		pw.print("hello");
		if(action.equals("add"))
		{
		String foodName=req.getParameter("fname");
		String foodType=req.getParameter("ftype");
		String foodCategory=req.getParameter("fcat");
		String foodImage=req.getParameter("fimage");
		String foodDescription=req.getParameter("fdes");
		double foodPrice=Double.parseDouble(req.getParameter("fprice"));
		Food food=new Food(foodName,foodType,foodCategory,foodImage,foodDescription,foodPrice);
		FoodDaoImpl fdao=new FoodDaoImpl();
		boolean flag=fdao.addFood(food);
		if(flag)
		{
			resp.sendRedirect("index.jsp");
		}
		else
		{
			resp.sendRedirect("Fail.jsp");
		}
		}
		else if(action.equals("update"))
		{
			int foodId=Integer.parseInt(req.getParameter("fid"));
			String foodName=req.getParameter("fname");
			String foodType=req.getParameter("ftype");
			String foodCategory=req.getParameter("fcat");
			String foodImage=req.getParameter("fimage");
			String foodDescription=req.getParameter("fdes");
			double foodPrice=Double.parseDouble(req.getParameter("fprice"));
			Food food=new Food(foodName,foodType,foodCategory,foodImage,foodDescription,foodPrice);
			food.setFoodId(foodId);
			FoodDaoImpl fdao=new FoodDaoImpl();
			boolean flag=fdao.updateFood(food);
			if(flag)
			{
				resp.sendRedirect("index.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
	
	}

}
