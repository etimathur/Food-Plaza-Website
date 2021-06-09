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

import foodplaza.dao.CustomerDaoImpl;
import foodplaza.dao.LoginDaoImpl;
import foodplaza.pojo.Customer;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action==null)
		{
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
		}
		else if(action.equals("check") && action!=null)
		{
			String email=req.getParameter("email");
			List<Customer> list=new CustomerDaoImpl().searchCustomerByEmail(email);
			resp.getWriter().write(list.size()!=0?"":"Account not found.");
		}
		else if(action.equals("checknot") && action!=null)
		{
			String email=req.getParameter("email");
			List<Customer> list=new CustomerDaoImpl().searchCustomerByEmail(email);
			System.out.println("Login Servlet");
			resp.getWriter().write(list.size()==0?"":"Account already Present");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LoginDaoImpl ldao=new LoginDaoImpl();
		PrintWriter pw=resp.getWriter();
		HttpSession session=req.getSession();
		boolean flag;
		String action=req.getParameter("action");
		if(action.equals("login") && action!=null)
		{
			String type=req.getParameter("type");
			String email=req.getParameter("email");
			String password=req.getParameter("pass");
			if(type.equals("Admin") && type!=null)
			{
				flag=ldao.adminLogin(email, password);
				if(flag)
				{
					session.setAttribute("admin", email);
					resp.sendRedirect("index.jsp");
				}
				else
				{
					resp.sendRedirect("Fail.jsp");
				}
			}
			else if(type.equals("Customer") && type!=null)
			{
				flag=ldao.customerLogin(email, password);
				if(flag)
				{
					session.setAttribute("user", email);
					resp.sendRedirect("index.jsp");
				}
				else
				{
					resp.sendRedirect("Fail.jsp");
				}
			}
		}
		else if(action.equals("PassChange"))
		{
			String type=req.getParameter("type");
			String email=req.getParameter("email");
			String oldPassword=req.getParameter("oldpass");
			String newPassword=req.getParameter("newpass");
			if(type.equals("Admin") && type!=null)
			{
				flag=ldao.changeAdminPassword(email, oldPassword, newPassword);
				if(flag)
				{
					session.setAttribute("admin", email);
					resp.sendRedirect("index.jsp");
				}
				else
				{
					resp.sendRedirect("Fail.jsp");
				}
			}
			else if(type.equals("Customer") && type!=null)
			{
				flag=ldao.changeCustomerPassword(email, oldPassword, newPassword);
				if(flag)
				{
					session.setAttribute("user", email);
					resp.sendRedirect("index.jsp");
				}
				else
				{
					resp.sendRedirect("Fail.jsp");
				}
		}
	}

}
}