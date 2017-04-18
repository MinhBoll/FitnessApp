package FitnessApp;

import javax.swing.*;
import java.awt.event.*;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class MacroGUI extends JDialog {
    private JPanel contentPane;
    private JTextField calInput;
    private JTextField fatPctInput;
    private JTextField carbPctInput;
    private JTextField proteinPctInput;
    private JButton calculateMacrosButton;
    private JLabel fatOutput;
    private JLabel carbsOutput;
    private JLabel proteinOutput;
    private JLabel outputLabel;
    public static long fat, carb, protein;
    double fatPct, carbPct, proteinPct;

    public MacroGUI() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        calculateMacrosButton.addActionListener(e -> {
            int cal = Integer.parseInt(calInput.getText());
            fatPct = Integer.parseInt(fatPctInput.getText());
            carbPct = Integer.parseInt(carbPctInput.getText());
            proteinPct = Integer.parseInt(proteinPctInput.getText());

            if(fatPct+carbPct+proteinPct!=100) {
                outputLabel.setText("Oops that doesn't add up to 100!");
            } else {
                calcMacros(cal);

                fatOutput.setText(Long.toString(fat));
                carbsOutput.setText(Long.toString(carb));
                proteinOutput.setText(Long.toString(protein));
            }
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

    public void calcMacros(int calories){
        fat = round(floor((calories * (fatPct/100))/9));
        carb = round(floor((calories * (carbPct/100))/4));
        protein = round(floor((calories * (proteinPct/100))/4));
    }

    public static void main(String[] args) {
        MacroGUI dialog = new MacroGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
