package foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import foodplaza.dao.FoodDaoImpl;
import foodplaza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) throws IOException 
	{
		
		int choice;
		int foodId;
		String foodName;
	    String foodType;
		String foodCategory;
		String foodImage;
		String foodDescription;
		double foodPrice;
		boolean ans;
		Iterator i;
		Food food;
		List <Food> list;
		FoodDaoImpl fdao=new FoodDaoImpl();
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter "
		+"\n1:Add Food "
		+ "\n2:Update Food"
		+"\n3:Delete Food "
		+ "\n4:Search Food By Id "
		+ "\n5:Search Food By Name "
		+ "\n6:Search Food By Type "
		+ "\n7:Search Food By Category "
		+ "\n8:Get All Food "
		+ "\n9:EXIT");

		choice =sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("--Add Food--");
			System.out.println("Enter Food Name :");
			foodName=br.readLine();
			System.out.println("Enter Food Type :");
			foodType=br.readLine();
			System.out.println("Enter Food Category :");
			foodCategory=br.readLine();
			System.out.println("Enter Food Image :");
			foodImage=br.readLine();
			System.out.println("Enter Food Description :");
			foodDescription=br.readLine();
			System.out.println("Enter Food Price :");
			foodPrice=sc.nextDouble();
			food=new Food(foodName, foodType, foodCategory, foodImage, foodDescription, foodPrice);
			ans=fdao.addFood(food);
			if(ans=true)
				System.out.println("Successfully added");
			else
				System.out.println("Failed");
			break;
		case 2:
			System.out.println("--Update Food--");
			System.out.println("Enter Food Id :");
			foodId=sc.nextInt();
			System.out.println("Enter Food Name :");
			foodName=br.readLine();
			System.out.println("Enter Food Type :");
			foodType=br.readLine();
			System.out.println("Enter Food Category :");
			foodCategory=br.readLine();
			System.out.println("Enter Food Image :");
			foodImage=br.readLine();
			System.out.println("Enter Food Description :");
			foodDescription=br.readLine();
			System.out.println("Enter Food Price :");
			foodPrice=sc.nextDouble();
			food=new Food(foodName, foodType, foodCategory, foodImage, foodDescription, foodPrice);
			food.setFoodId(foodId);
			ans=fdao.updateFood(food);
			if(ans)
				System.out.println("Successfully updated");
			else
				System.out.println("Failed");
			break;
		case 3:
			System.out.println("--Delete Food--");
			System.out.println("Enter Food Id :");
			foodId=sc.nextInt();
			ans=fdao.deleteFood(foodId);
			if(ans)
				System.out.println("Successfully deleted");
			else
				System.out.println("Failed");
			break;
		case 4:
			System.out.println("--Search Food By Id--");
			System.out.println("Enter Food Id :");
			foodId=sc.nextInt();
			food=fdao.searchFoodById(foodId);
			if(food!=null)
			System.out.println(food);
			else
			System.out.println("Food Not Found");
			break;
		case 5:
			System.out.println("--Search Food by Name--");
			System.out.println("Enter Food Name :");
			foodName=br.readLine();
			list=fdao.searchFoodByName(foodName);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Food Not found");
			
			break;
		case 6:
			System.out.println("--Search Food by Type--");
			System.out.println("Enter Food Type :");
			foodType=br.readLine();
			list=fdao.searchFoodByName(foodType);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Food Not found");
			
			break;
		case 7:
			System.out.println("--Search Food by Category--");
			System.out.println("Enter Food Category :");
			foodCategory=br.readLine();
			list=fdao.searchFoodByName(foodCategory);
			if(!list.isEmpty())
			{
				i=list.iterator();
				while(i.hasNext())
				{
					System.out.println(i.next());
				}
			}
			else
				System.out.println("Food Not found");
			
			break;
		case 8:
			System.out.println("--Get All Food--");
			list=fdao.getAllFood();
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
		case 9:
			System.exit(0);
		}
	}
}
