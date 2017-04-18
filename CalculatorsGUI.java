package FitnessApp;

import javax.swing.*;
import java.awt.event.*;

public class CalculatorsGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton a3aButton;
    private JButton a3bButton;
    MacroGUI newMacro = new MacroGUI();
    WilksGUI newWilks = new WilksGUI();

    public CalculatorsGUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        a3aButton.addActionListener(e -> {
            newMacro.pack();
            newMacro.setVisible(true);
        });

        a3bButton.addActionListener(e -> {
            newWilks.bodyweightInput.setText(Double.toString(Register.bodyweight));
            newWilks.genderInput.setText(Register.genderName);
            newWilks.convInput.setText(Register.conv);
            newWilks.pack();
            newWilks.setVisible(true);
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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

    public static void main(String[] args) {
        CalculatorsGUI dialog = new CalculatorsGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
