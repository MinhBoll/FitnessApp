package FitnessApp;
 
import java.util.Scanner;
 

import static java.lang.Math.*;
 
/**
 * Created by Alec on 3/17/16.
 */
public class MacroCalc {
    private long protein = 0;
    private long carb = 0;
    public long fat = 0;
    private double proteinPct = 1.01;
    private double carbPct = 1.01;
    private double fatPct = 1.01;
    int calories;
 
    MacroCalc(){
 
    }
 
    void start(){
        boolean loop = true;
 
        while(loop) {
            showMenu();
            Scanner input = new Scanner(System.in);
            int input1 = input.nextInt();
 
            switch (input1) {
                case 1:
                    InputPercentages();
                    break;
                case 2:
                    suggestions();
                    Scanner sugg = new Scanner(System.in);
                    int suggInput = Integer.parseInt(sugg.nextLine());
 
                    switch(suggInput){
                        case 1:
                            setPercentages(20, 55, 25);
                            break;
                        case 2:
                            setPercentages(30, 40, 30);
                            break;
                        case 3:
                            setPercentages(40, 25, 35);
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    showMacros();
                default:
                    break;
            }
            System.out.println("Would you like to continue? Type 'yes' or 'no'");
            Scanner cont = new Scanner(System.in);
            String contInput = cont.nextLine();
 
            loop = contInput.equals("yes");
        }
    }
 
    private void InputPercentages(){
        boolean valid = false;
 
        if(calories == 0){
            System.out.println("Whoops, don't forget to put in your calories!");
            Scanner caloriesInput = new Scanner(System.in);
            calories = Integer.parseInt(caloriesInput.nextLine());
        }
 
        if(fatPct == 1.01 && carbPct == 1.01 && proteinPct == 1.01) {
            while(!valid) {
                System.out.println("Do not include % with input.. (must add up to 100%)");
                System.out.println("Fat: ");
                Scanner fat = new Scanner(System.in);
                int fatInput = Integer.parseInt(fat.nextLine());
 
                System.out.println("Carbs: ");
                Scanner carb = new Scanner(System.in);
                int carbInput = Integer.parseInt(carb.nextLine());
 
                System.out.println("Protein: ");
                Scanner protein = new Scanner(System.in);
                int proteinInput = Integer.parseInt(protein.nextLine());
 
                int total = fatInput + carbInput + proteinInput;
 
                setPercentages(fatInput, carbInput, proteinInput);
                calcMacros(calories);
 
                if(total != 100){
                    valid = false;
                    if(total > 100){
                        System.out.println("You put in too much, your total was: " + total + ", it should add up to 100");
                    } else if (total < 100){
                        System.out.println("You put in too little, your total was: " + total + ", it should add up to 100");
                    }
                } else {
                    valid = true;
                }
            }
        }
    }
 
    private void setPercentages(int fatInput, int carbInput, int proteinInput){
        fatPct = (double)fatInput/100;
        carbPct = (double)carbInput/100;
        proteinPct = (double)proteinInput/100;
    }
 
    private void showMenu(){
        System.out.println("(1)Input your percentages");
        System.out.println("(2)Get some suggestions");
        System.out.println("(3)Show Macros");
        System.out.println("(4)Exit");
    }
 
    private void suggestions(){
        System.out.println("(1) Ectomorph: If you're an ectomorph, you're naturally thin\n " +
                "with skinny limbs and a high tolerance for carbohydrates. Usually, your\n " +
                "metabolic rate is fast. A good starting macronutrient ratio for you would\n " +
                "be something like 25% protein, 55% carbs and 20% fat.");
        System.out.println("(2) Mesomorph: Mesomorphs are naturally muscular and athletic.\n " +
                "They have a moderate carbohydrate tolerance and a moderate metabolic rate.\n " +
                "Mesomorphs can usually start at a 30% protein, 40% carb, 30% fat macro-nutrient ratio.");
        System.out.println("(3) Endomorph: If you're naturally broad and thick, you're probably an endomorph.\n " +
                "Endomorphs have a low carbohydrate tolerance and a slow metabolic rate.\n " +
                "If you're an endomorph, try a ratio of 35% protein, 25% carbs and 40% fat.");
    }
 
    private void showMacros(){
        if((fat == 0) && (protein == 0) && (carb == 0)){
            System.out.println("You haven't calculated your macros yet!");
            System.out.println("Would you like to now?");
            Scanner cont = new Scanner(System.in);
            String contInput = cont.nextLine();
 
            boolean input = contInput.equals("yes");
            if(input) {
                InputPercentages();
            }
        } else {
            System.out.println("Fats: " + fat + ", Protein: " + protein + ", Carbs: " + carb);
        }
    }
 
    public void calcMacros(int calories){
        fat = round(floor((calories * (fatPct))/9));
        carb = round(floor((calories * (carbPct))/4));
        protein = round(floor((calories * (proteinPct))/4));
    }

    public long getProtein(){
 	   return protein;
    }
    public void setProtein(long protein){
 	   this.protein = protein;
    }
    public long getCarb(){
  	   return carb;
     }
     public void setCarb(long carb){
  	   this.carb = carb;
     }
     public long getFat(){
    	   return fat;
     }
     public void setfat(long fat){
    	   this.fat = fat;
     }
    @Override
    public String toString(){
        return "Fats: " + fat + ", Protein: " + protein + ", Carbs: " + carb;
    }
 
    public static void main(String[] args){
        MacroCalc newCalc = new MacroCalc();
 
        newCalc.start();
    }
}
