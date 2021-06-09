package foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodplaza.dao.CartDaoImpl;
import foodplaza.dao.CustomerDaoImpl;
import foodplaza.pojo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet{
	
	Customer customer;
	CustomerDaoImpl cdao=new CustomerDaoImpl();
	List list;
	CartDaoImpl cartdao=new CartDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		String user=req.getParameter("user");
		boolean flag,flag2;
		if(action!=null && action.equals("update"))
		{
		
			list=cdao.searchCustomerByEmail(user);
			System.out.println("Update "+list);
			customer=(Customer) list.get(0);
			if(customer!=null)
			{
				req.setAttribute("customer",customer );
				RequestDispatcher rd=req.getRequestDispatcher("UpdateCustomer.jsp");
				rd.include(req, resp);
				
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
		else if(action!=null && action.equals("delete"))
		{
			
			flag=cdao.deleteCustomerByEmail(user);
			flag2=cartdao.clearCart(user);
			if(flag && flag2)
			{
				session.invalidate();
				resp.sendRedirect("index.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
			
		}
		else {
			
			list=cdao.getAllCustomer();
			session.setAttribute("list", list);
			resp.sendRedirect("CustomerList.jsp");
		}
	
	}	
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String action=req.getParameter("action");
		if(action !=null && action.equals("UpdateCust") )
		{
			int custId=Integer.parseInt(req.getParameter("id"));
			String custName=req.getParameter("name");
			String custEmail=req.getParameter("email");
			String custPassword=req.getParameter("pass");
			String custAddress=req.getParameter("add");
			long custContactNo=Long.parseLong(req.getParameter("con"));
			Customer customer=new Customer(custName,custEmail,custPassword,custAddress,custContactNo);
			customer.setCustId(custId);
			CustomerDaoImpl cdao=new CustomerDaoImpl();
			boolean flag=cdao.updateCustomerById(customer);
			if(flag)
			{
				resp.sendRedirect("Successfull.jsp");
			}
			else
				resp.sendRedirect("Fail.jsp");
		}
		else if(action!=null && action.equals("AddCust"))
		{
			String custName=req.getParameter("name");
			String custEmail=req.getParameter("email");
			String custPassword=req.getParameter("pass");
			String custAddress=req.getParameter("add");
			long custContactNo=Long.parseLong(req.getParameter("con"));
			Customer customer=new Customer(custName,custEmail,custPassword,custAddress,custContactNo);
			CustomerDaoImpl cdao=new CustomerDaoImpl();
			boolean flag=cdao.addCustomer(customer);
			if(flag)
			{
				resp.sendRedirect("index.jsp");
			}
			else
				resp.sendRedirect("Fail.jsp");
		}
	}

}
