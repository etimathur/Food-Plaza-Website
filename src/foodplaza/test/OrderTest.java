package foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import foodplaza.dao.OrderDaoImpl;
import foodplaza.pojo.Order;

public class OrderTest {

	public static void main(String[] args) throws IOException {
		
		int orderId;
		double orderBill;
		String custEmailId,orderStatus,orderDate;
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Order order;
		List <Order> list;
		Iterator i;
		boolean ans;
		OrderDaoImpl odao=new OrderDaoImpl();
		int choice;
		do {
		System.out.println("Enter \n1:Place Order \n2:Place Order \n3:Cancel Order \n4:Show Order \n5:Show All Order \n6:EXIT");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("--PLACE ORDER--");
			System.out.println("Enter Email Id");
			custEmailId=br.readLine();
			ans=odao.placeOrder(custEmailId);
			if(ans)
				System.out.println("ORDER PLACED");
			else
				System.out.println("Failed");
			break;
		case 2:
			break;
		case 3:
			System.out.println("--CANCEL ORDER --");
			System.out.println("Enter Order Id");
			orderId=sc.nextInt();
			ans=odao.cancelOrder(orderId);
			if(ans)
				System.out.println("ORDER CANCELLED");
			else
				System.out.println("Failed");
			break;
		case 4:
			System.out.println("--SHOW ORDER --");
			System.out.println("Enter Email Id");
			custEmailId=br.readLine();
			list=odao.showOrder(custEmailId);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Order not Found");
			break;
		case 5:
			System.out.println("--SHOW ALL ORDER--");
			list=odao.showAllOrder();
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("No Order Found");
			break;
		
	}
		}while(choice!=6);
}
}
