package FitnessApp;

import java.io.*;
import java.util.*;


/**
 * Created by Alec on 3/17/16.
 */
public class Register {
    private MacroCalc newCalc = new MacroCalc();
    public static String username = "";
    private String password;
    public static double bodyweight = 0;
    double conversion;
    boolean gender;
    public static String conv = "";
    public static String genderName = "";

    Register() throws IOException {

    }

    boolean checkForUsername(String u) throws FileNotFoundException {
        String fileName1 = "src/FitnessApp/userDatabase.txt";
        Scanner scanner1 = new Scanner(new File(fileName1));
        String usernameIn1;

        boolean found = false;

        while(scanner1.hasNext()) {
            String output = scanner1.nextLine();
            String[] split = output.split("\\|");
            usernameIn1 = split[0];
            if (u.equals(usernameIn1)) {
                found = true;
            }

        }

        return found;

    }

    String checkSignIn(String u, String p) throws FileNotFoundException {
        String fileName = "src/FitnessApp/userDatabase.txt";
        Scanner scanner = new Scanner(new File(fileName));
        String usernameIn;
        String passwordIn;
        String result;
        boolean found = false;

        while(scanner.hasNext()) {
            String output = scanner.nextLine();
            String[] split = output.split("\\|");
            usernameIn = split[0];
            passwordIn = split[1];
            if(u.equals(usernameIn)) {
                if (p.equals(passwordIn)) {
                    username = u;
                    found = true;
                    genderName = split[2];
                    conv = split[3];
                    bodyweight = Double.parseDouble(split[4]);
                }
            }
        }
        if(found){
            result = "Log in success!";
//            System.out.println("Gender: " + genderName);
//            System.out.println("Conversion: " + conv);
//            System.out.println("Bodyweight: " + bodyweight);

        } else {
            result = "Oops something went wrong. Try again!";
        }

        return result;
    }

    void signUp() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.print("Please provide us with a little more information");
        System.out.println();
        setBasicInfo();
    }

    void signIn() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String u = scanner.nextLine();
        System.out.print("Enter password: ");
        String p = scanner.nextLine();

        checkSignIn(u,p);
//        String fileName = "src/FitnessApp/userDatabase.txt";
//        Scanner scanner1 = new Scanner(new File(fileName));
//        String output = scanner1.nextLine();
//
//        while(!output.equals("")) {
//            String[] split = output.split("\\|");
//            usernameIn = split[0];
//            passwordIn = split[1];
//
//            if(username.equals(usernameIn))
//                if(password.equals(passwordIn))
//                    System.out.println("Log In Success");
//
//        }

    }

    void setBasicInfo() throws IOException {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int completed = 0;

        if (genderName.equals("boy")||genderName.equals("girl")) {
            completed++;
        } else {
            System.out.println("Are you a 'boy' or 'girl'?");
            String genderInput = input2.nextLine();
            gender = genderInput.equals("boy");

            if (gender) {
                genderName = "boy";
            } else {
                genderName = "girl";
            }
        }
        if (conv.equals("lb") || conv.equals("kg")) {
            completed++;
        } else {
            System.out.println("Would you like your input to be in kg or lb?");
            conv = input1.nextLine();

            if (conv.equals("lb")) {
                conversion = 2.20462;
            } else if (conv.equals("kg")) {
                conversion = 1.0;
            }
        }
        if(bodyweight!=0) {
            completed++;
        } else {
            System.out.println("What is your bodyweight?");
            bodyweight = input3.nextDouble();
        }

//        if(newCalc.calories!=0){
//            completed++;
//        } else {
//            System.out.println("How many calories do you consume in a day?");
//            newCalc.calories = input4.nextInt();
//        }

        if (completed == 3) {
            System.out.println("We have all the info we need!");
        } else {
            System.out.println("Additional info has been set!");
            writeToDB(username, password, genderName, conv, bodyweight);
        }
    }


//    void writeToDB(String username, String password) throws IOException {
//        fileWriter = new FileWriter("src/FitnessApp/userDatabase.txt",true);
//        fileWriter.write(username + " || " + password + "\n");
//        fileWriter.close();
//    }

    public void writeToDB(String username, String password, String gender, String conv, double bw) throws IOException {
        FileWriter fileWriter = new FileWriter("src/FitnessApp/userDatabase.txt", true);
        fileWriter.write(username + "|" + password + "|" + gender + "|" + conv + "|" + bw  + "|\n");
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Register newUser = new Register();

        //newUser.signUp();
        //newUser.readFromFile();
        newUser.signIn();
    }
}
