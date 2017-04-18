package FitnessApp;

import javax.swing.*;
import java.awt.event.*;

public class MacroTrackerGUI extends JDialog {
    private JPanel contentPane;
    private JButton inputFoodsButton;
    private JButton trackMacrosButton;
    MacroNutrientTrackerGui newMacroTracker = new MacroNutrientTrackerGui();
    foodGui newFoodGUI = new foodGui();

    public MacroTrackerGUI() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        inputFoodsButton.addActionListener(e -> {
            newFoodGUI.pack();
            newFoodGUI.setVisible(true);
        });

        trackMacrosButton.addActionListener(e -> {
            newMacroTracker.fatsOutput.setText(Long.toString(MacroGUI.fat));
            newMacroTracker.carbsOutput.setText(Long.toString(MacroGUI.carb));
            newMacroTracker.proteinOuput.setText(Long.toString(MacroGUI.protein));
            newMacroTracker.currentFatsOutput.setText(Long.toString(MacroGUI.fat));
            newMacroTracker.currentCarbsOutput.setText(Long.toString(MacroGUI.carb));
            newMacroTracker.currentProteinOuput.setText(Long.toString(MacroGUI.protein));
            long currentCalories = ((MacroGUI.fat*9)+(MacroGUI.carb*4)+(MacroGUI.protein*4));
            newMacroTracker.caloriesTextField.setText(Long.toString(currentCalories));
            newMacroTracker.pack();
            newMacroTracker.setVisible(true);
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MacroTrackerGUI dialog = new MacroTrackerGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
