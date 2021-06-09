package foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import foodplaza.dao.CartDaoImpl;
import foodplaza.pojo.Cart;

public class CartTest {
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cartId,foodId,foodQuantity;
		String custEmail;
		Iterator i;
		List<Cart> list;
		Cart cart;
		int choice;
		boolean ans;
		CartDaoImpl cusdao=new CartDaoImpl();
		do
		{
		System.out.println("Enter \n1:Add Cart \n2:Delete Cart by Id \n3:Delete Food from Cart \n4:Delete Food by Cart Id\n5:Get all Food from Cart \n5:EXIT\n");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter food Id");
			foodId=sc.nextInt();
			System.out.println("Enter Email Id");
			custEmail=br.readLine();
			System.out.println("Enter Food Quantity");
			foodQuantity=sc.nextInt();
			cart=new Cart(foodId, foodQuantity, custEmail);
			ans=cusdao.addToCart(cart);
			if(ans)
			System.out.println("Added Successfully");
			else
				System.out.println("Failed");
			break;
		case 2:
			System.out.println("Enter Existing Email Id");
			custEmail=br.readLine();
			ans=cusdao.clearCart(custEmail);
			if(ans)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Failed");
			break;
		case 3:
			System.out.println("Enter Existing Email Id");
			custEmail=br.readLine();
			System.out.println("Enter food Id");
			foodId=sc.nextInt();
			ans=cusdao.clearCart(custEmail, foodId);
			if(ans)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Failed");
			break;
		case 4:
			System.out.println("Enter cart Id");
			cartId=sc.nextInt();
			ans=cusdao.deleteCart(cartId);
			if(ans)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Failed");
			break;
		case 5:
			System.out.println("All Cart Food");
			System.out.println("Enter Existing Email Id");
			custEmail=br.readLine();
			list=cusdao.showCart(custEmail);
			
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("No Cart Found");
			break;
		case 6:
			
			break;
		default:
			System.out.println("Invaid Input");
			
		}
		}while(choice!=5);
		
	}

}
