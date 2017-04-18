package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class foodGui extends JDialog {
    private JPanel contentPane;
    private JTextField foodNameTextField;
    private JTextField carbTextField;
    private JTextField fatTextField;
    private JTextField proteinTextField;
    private JButton makeNewFoodButton;
    private JTextArea printDatabase;
    private JButton database;
    private JTextArea inputVal;
    public static  List<Food> foodDatabase = new ArrayList<Food>();

    public foodGui() {
        setContentPane(contentPane);
        setModal(true);
        makeNewFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food food1 = new Food();
                if(carbTextField.getText().equals("")
                        || fatTextField.getText().equals("") || proteinTextField.getText().equals("")
                        || foodNameTextField.getText().equals("")){
                    String valText = "One or more of your Field have not been entered";
                    inputVal.setText(valText);}
                String foodName = foodNameTextField.getText();
                long carb = Long.parseLong(carbTextField.getText());
                long fat = Long.parseLong(fatTextField.getText());
                long protein = Long.parseLong(proteinTextField.getText());

                if((carb <= 0 || fat <= 0 || protein <= 0)){
                     String valText = "One or more of your Macros inputed are less than or = to 0. Try Again!";
                    inputVal.setText(valText);
                }else{
                    food1.food(foodName,carb,fat,protein);
                    foodDatabase.add(food1);
                }
            }
        });
        database.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDatabase.setText(foodDatabase.toString());
                foodNameTextField.setText("");
                carbTextField.setText("");
                fatTextField.setText("");
                proteinTextField.setText("");

            }
        });
    }
    public static void main(String[] args) {
        foodGui dialog = new foodGui();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
