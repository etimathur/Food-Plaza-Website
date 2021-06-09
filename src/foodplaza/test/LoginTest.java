package foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import foodplaza.dao.LoginDaoImpl;

public class LoginTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		LoginDaoImpl ldao=new LoginDaoImpl();
		String email,password,oldpassword;
		boolean flag;
		int choice;
		do {
			System.out.println("Enter 1:Admin Login \n2:Customer Login \n3:Admin Password Change \n4:Customer Password Change \n5:Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Admin Email");
				email=br.readLine();
				System.out.println("Enter Admin Password");
				password=br.readLine();
				flag=ldao.adminLogin(email, password);
				if(flag)
					System.out.println("Successfull Login");
				else
					System.out.println("Failed Login");
				break;
			case 2:
				System.out.println("Enter Customer Email");
				email=sc.next();
				System.out.println("Enter Customer Password");
				password=sc.next();
				flag=ldao.customerLogin(email, password);
				if(flag)
					System.out.println("Successfull Login");
				else
					System.out.println("Failed Login");
				break;
			case 3:
				System.out.println("Enter Admin Email");
				email=sc.next();
				System.out.println("Enter Admin Old Password");
				oldpassword=sc.next();
				System.out.println("Enter Admin New Password");
				password=sc.next();
				flag=ldao.changeAdminPassword(email, oldpassword,password);
				if(flag)
					System.out.println("Successfull Change in Password");
				else
					System.out.println("Failed Password Change");
				break;
			case 4:
				System.out.println("Enter Customer Email");
				email=sc.next();
				System.out.println("Enter Customer Old Password");
				oldpassword=sc.next();
				System.out.println("Enter Customer New Password");
				password=sc.next();
				flag=ldao.changeCustomerPassword(email, oldpassword, password);
				if(flag)
					System.out.println("Successfull Change in Password");
				else
					System.out.println("Failed Password Change");
				
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Input");
				break;
				
				
			}
		}while(choice!=5);
		sc.close();
	}
}
