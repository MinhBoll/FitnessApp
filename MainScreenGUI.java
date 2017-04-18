package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class MainScreenGUI extends JDialog {
    SignInGui signInDialog;
    SignUpGUI signUpDialog;
    private JPanel contentPane;
    private JButton signInButton;
    private JButton signUpButton;

    public MainScreenGUI() throws IOException{
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        signInButton.addActionListener(e -> {
            if(signInDialog.outputLabel.getText().equals("Log in success!")){
                signInDialog.outputLabel.setText("");
            }
            signInDialog.pack();
            signInDialog.setVisible(true);
        });

        signUpButton.addActionListener(e -> {
            signUpDialog.pack();
            signUpDialog.setVisible(true);
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

        signInDialog = new SignInGui();
        signUpDialog = new SignUpGUI();
    }

    private void onCancel(){
        dispose();
    }

    public static void main(String[] args) throws IOException{
        MainScreenGUI dialog = new MainScreenGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
