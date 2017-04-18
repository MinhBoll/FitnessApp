package FitnessApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MacroNutrientTrackerGui extends JDialog {
    private JPanel contentPane;
    public JLabel fatsOutput;

    public JLabel carbsOutput;
    public JLabel proteinOuput;
    public JLabel currentFatsOutput;
    public JLabel currentCarbsOutput;
    public JLabel currentProteinOuput;
    private JTextArea printDatabase;
    private JButton subtractFoodButton;
    private JButton showFoodsButton;
    private JTextField foodInput;
    public JLabel caloriesTextField;
    private JTextArea dailyMacroGoal;
    private JButton buttonOK;
    MacroCalc yourMacroCalc = new MacroCalc();
    MacroGUI newMacroGUI = new MacroGUI();

    public MacroNutrientTrackerGui() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

//        yourMacroCalc.setCarb(MacroGUI.carb);
//        yourMacroCalc.setfat(newMacroGUI.fat);
//        yourMacroCalc.setProtein(newMacroGUI.protein);
//        dailyMacroGoal.setText(yourMacroCalc.toString());
        showFoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDatabase.setText(foodGui.foodDatabase.toString());
            }
        });
        subtractFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String food = foodInput.getText();
                for(int i = 0; i< foodGui.foodDatabase.size(); i++){
                    if((foodGui.foodDatabase.get(i).getFoodName() != "")
                            && (foodGui.foodDatabase.get(i).getFoodName().contains(food))){

                        long currentFat = Long.parseLong(currentFatsOutput.getText());
                        long currentCarb = Long.parseLong(currentCarbsOutput.getText());
                        long currentProtein = Long.parseLong(currentProteinOuput.getText());


                        if(currentFat <= 0){
                            currentFat = 0;
                            foodGui.foodDatabase.get(i).setFats(0);
                        }else if(currentFat < foodGui.foodDatabase.get(i).getFats() ) {

                            currentFat = 0;
                            foodGui.foodDatabase.get(i).setFats(0);
                        }
                        if(currentCarb <= 0){
                            currentFat = 0;
                            foodGui.foodDatabase.get(i).setCarbs(0);
                        }else if(currentCarb < foodGui.foodDatabase.get(i).getcarbs() ) {

                            currentCarb = 0;
                            foodGui.foodDatabase.get(i).setCarbs(0);
                        }
                        if(currentProtein <= 0){
                            currentProtein = 0;
                            foodGui.foodDatabase.get(i).setProtein(0);
                        }else if(currentCarb < foodGui.foodDatabase.get(i).getProtein() ) {

                            currentProtein = 0;
                            foodGui.foodDatabase.get(i).setProtein(0);
                        }
                        currentFat = currentFat - foodGui.foodDatabase.get(i).getFats();
                        currentCarb = currentCarb - foodGui.foodDatabase.get(i).getcarbs();
                        currentProtein = currentProtein - foodGui.foodDatabase.get(i).getProtein();




                            currentFatsOutput.setText(Long.toString(currentFat));
                            currentCarbsOutput.setText(Long.toString(currentCarb));
                            currentProteinOuput.setText(Long.toString(currentProtein));

                    }
                }


            }

        });
    }


    public static void main(String[] args) {
        MacroNutrientTrackerGui dialog = new MacroNutrientTrackerGui();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
