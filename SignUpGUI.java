package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SignUpGUI extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton nextStepButton;
    private JTextPane textPane1;
    public static String SignUpGuiUsername = "";
    public static String SignUpGuiPassword = "";
    BasicInfoGUI infoDialog;
    HomeScreenGui showMenu = new HomeScreenGui();
    Register newRegister = new Register();

    public SignUpGUI() throws IOException {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        });
//
//        buttonCancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        });

        infoDialog = new BasicInfoGUI();
        nextStepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpGuiUsername = textField1.getText();
                SignUpGuiPassword = passwordField1.getText();
                String cpassword = passwordField2.getText();

                try {
                    if(newRegister.checkForUsername(SignUpGuiUsername)){
                        textPane1.setText("Sorry that username is taken!");
                    } else {
                        if(!SignUpGuiPassword.equals(cpassword)){
                            textPane1.setText("Passwords Do Not Match!");
                        } else {
                            textPane1.setText("Success!");
                            Register.username = SignUpGuiUsername;
                            onCancel();
                            infoDialog.pack();
                            infoDialog.setVisible(true);

                        }
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }


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

    public static void main(String[] args) throws IOException{
        SignUpGUI dialog = new SignUpGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
