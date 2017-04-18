package FitnessApp;

import javax.swing.*;
import java.awt.event.*;

public class SeeInfoGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel usernameLabel;
    private JLabel bodyweightLabel;
    public JLabel usernameOutput;
    public JLabel bodyweightOutput;
    public JLabel convOutput;
    public JLabel genderOutput;

    public SeeInfoGUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        if(Register.username != "") {
            usernameOutput.setText(Register.username);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        SeeInfoGUI dialog = new SeeInfoGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
