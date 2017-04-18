package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SignInGui extends JDialog {
    Register newUser;
    String result;
    HomeScreenGui showMenu = new HomeScreenGui();
    private JPanel contentPane;

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    public JLabel outputLabel;

    public SignInGui() throws IOException {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        signInButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
                String username = textField1.getText();
                String password = passwordField1.getText();
                try {
                    onSignIn(username,password);
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
        newUser = new Register();
    }

    private void onOK() throws FileNotFoundException {
// add your code here

    }

    private void onSignIn(String u, String p) throws FileNotFoundException {

        result = newUser.checkSignIn(u, p);
        outputLabel.setText(result);

        if(result.equals("Log in success!")) {
            this.dispose();
            showMenu.pack();
            showMenu.setVisible(true);
        } else {
            this.dispose();
            this.pack();
            this.setVisible(true);
        }

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException {
        SignInGui dialog = new SignInGui();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
