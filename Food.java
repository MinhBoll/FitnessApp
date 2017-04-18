package FitnessApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Food {
	
   protected final static String DEFAULT_WORD_FILE_NAME = "src/FitnessApp/Foods.txt";
   private String foodName = "";
   
   private long carbs = 0;
   private long fats = 0;
   private long protein = 0;
   public List<Food> foodDatabase = new ArrayList<Food>();

   public void food(String foodName,long carbs, long fats, long protein) {
	   this.foodName = foodName;
	   this.carbs = carbs;
	   this.fats = fats;
	   this.protein = protein;
   }
   
   public void makeNewFood(){
	   	String continueYN;
	   	String continueYN1;
		Scanner Scan = new Scanner(System.in);

		System.out.println("Do you want to make a new Food (y/n)\n");
		continueYN = Scan.nextLine();
		switch(continueYN) {
		
		case "y":
		System.out.println("Enter the Name of the food.");
		String foodName = Scan.nextLine();

		System.out.println("Input the amount of Fats contained in this food");
		int fats = Scan.nextInt();
		System.out.println("Input the amount of Carbs contained in this food");
		int carbs = Scan.nextInt();
		System.out.println("Input the amount of protein contained in this food");
		int protein = Scan.nextInt();
		Food food1 = new Food();
		System.out.print("Food Name: "+foodName+"\nCalories: "+"\nFats: "+fats+"\nCarbs: "+carbs+"\nProtein: "+protein+"\n");
		food1.food(foodName,carbs,fats,protein);
		foodDatabase.add(food1);
		System.out.println("Would you like to Input another food into the Database?");
		continueYN1 = Scan.nextLine();
		if(continueYN.equals("y")){
			makeNewFood();
		}
		break;
		case "n":
			break;
		default: 
			System.out.println("Not a valid choice!\n Please try again!\n");
			makeNewFood();
		}
   }
   public String getFoodName(){
	   return foodName;
   }
   public long getcarbs(){
	   return carbs;
   }
   public long getFats(){
	   return fats;
   }
   public long getProtein(){
	   return protein;
   }
   public List<Food> getFoodDatabase(){
	   return new ArrayList<>(foodDatabase);
   }
   public void setFoodName(String foodName){
	   this.foodName = foodName;
   }
   public void setCarbs(long carbs){
	   this.carbs = carbs;
   }
   public void setFats(long fats){
	   this.fats = fats;
   }
   public void setProtein(long protein){
	   this.protein = protein;
   }
   public String toString(){
	   return "Food Name: "+foodName+"\nFats: "+fats+"\nCarbs: "+carbs+"\nProtein: "+protein+"\n";
   }
   public static void main(String[] args) {
	   Food demoFood = new Food();
	   demoFood.makeNewFood();
	   System.out.println(demoFood.foodDatabase);
	}
}
