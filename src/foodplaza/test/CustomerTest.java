package foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import foodplaza.dao.CustomerDaoImpl;
import foodplaza.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) throws IOException {
		
	    int custId,choice;
		String custName,custEmail,custPassword,custAddress;
		List<Customer> list;
		Iterator i;
		long custContactNo;
		boolean ans;
		Customer cust;
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
		System.out.println("Enter \n1:New Customer \n2:Update Customer by Id\n3:Delete Customer by Id\n4:Search Customer by Id \n5:Search Customer by Email \n6:Get All Customer \n7:EXIT");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Customer Name");
			custName=br.readLine();
			System.out.println("Enter Customer Email");
			custEmail=br.readLine();
			System.out.println("Enter Customer Password");
			custPassword=br.readLine();
			System.out.println("Enter Customer Address");
			custAddress=br.readLine();
			System.out.println("Enter Customer Contact No");
			custContactNo=sc.nextLong();
			cust=new Customer(custName, custEmail, custPassword, custAddress, custContactNo);
			ans=cdao.addCustomer(cust);
			if(ans)
				System.out.println("Customer Added Successfully");
			else
				System.out.println("Failed");
			break;
			
		case 2:
			System.out.println("Enter Exiting Customer Id");
			custId=sc.nextInt();
			System.out.println("Enter Customer Name");
			custName=br.readLine();
			System.out.println("Enter Customer Email");
			custEmail=br.readLine();
			System.out.println("Enter Customer Password");
			custPassword=br.readLine();
			System.out.println("Enter Customer Address");
			custAddress=br.readLine();
			System.out.println("Enter Customer Contact No");
			custContactNo=sc.nextLong();
			cust=new Customer(custName, custEmail, custPassword, custAddress, custContactNo);
			cust.setCustId(custId);
			ans=cdao.updateCustomerById(cust);
			if(ans)
				System.out.println("Customer Update Successfully");
			else
				System.out.println("Failed");
			break;
			
		case 3:
			System.out.println("Enter Exiting Customer Id");
			custId=sc.nextInt();
			ans=cdao.deleteCustomerById(custId);
			if(ans)
				System.out.println("Customer Delete Successfully");
			else
				System.out.println("Failed");
			break;
		case 4:
			System.out.println("Enter Existing Customer Id");
			custId=sc.nextInt();
			list=cdao.searchCustomerById(custId);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Customer Not found");
			break;
		case 5:
			System.out.println("Enter Existing Customer Email");
			custEmail=br.readLine();
			list=cdao.searchCustomerByEmail(custEmail);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Customer Not found");
			break;
		case 6:
			System.out.println("Get all customer");
			list=cdao.getAllCustomer();
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("No Customer Found");
			break;
		case 7:
			
				break;
		default:
			System.out.println("Invalid Input");
		}
		}while(choice!=7);
	}
}
