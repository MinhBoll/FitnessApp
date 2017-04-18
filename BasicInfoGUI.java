package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class BasicInfoGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton boyRadioButton;
    private JRadioButton girlRadioButton;
    private JRadioButton kgRadioButton;
    private JRadioButton lbsRadioButton;
    private JTextField textField1;
    private String conv = "";
    public String gender = "";
    HomeScreenGui showMenu;
    Register newUser;

    public BasicInfoGUI() throws IOException{
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //showMenu.pack();
            //showMenu.setVisible(true);
        });

        buttonCancel.addActionListener(e -> onCancel());

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        showMenu = new HomeScreenGui();
        newUser = new Register();
    }

    private void onOK() throws IOException {
        if(boyRadioButton.isSelected()){
            gender = "boy";
        } else if(girlRadioButton.isSelected()){
            gender = "girl";
        }
        if(kgRadioButton.isSelected()){
            conv = "kg";
        } else if(lbsRadioButton.isSelected()){
            conv = "lbs";
        }
        float bodyweight = Float.parseFloat(textField1.getText());
        newUser.writeToDB(SignUpGUI.SignUpGuiUsername,SignUpGUI.SignUpGuiPassword,gender,conv, bodyweight);

        Register.bodyweight = bodyweight;
        Register.conv = conv;
        Register.genderName = gender;

        this.dispose();
        showMenu.pack();
        showMenu.setVisible(true);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException {
        BasicInfoGUI dialog = new BasicInfoGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
