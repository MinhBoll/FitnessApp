package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class HomeScreenGui extends JDialog {
    CalculatorsGUI calcDialog;
    SeeInfoGUI infoDialog;
    planGUI calendarDialog;
    MacroTrackerGUI trackerDialog;
    LogoutGUI logoutDialog;
    private JPanel contentPane;

    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;

    public HomeScreenGui() throws IOException {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        a2Button.addActionListener(e -> onA2Button());
        a3Button.addActionListener(e -> onA3Button());
        a4Button.addActionListener(e -> onA4Button());
        a5Button.addActionListener(e -> onA5Button());
        a6Button.addActionListener(e -> onA6Button());

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        calcDialog = new CalculatorsGUI();
        infoDialog = new SeeInfoGUI();
        calendarDialog = new planGUI();
        trackerDialog = new MacroTrackerGUI();
        logoutDialog = new LogoutGUI();

    }

    private void onA2Button() {
        infoDialog.usernameOutput.setText(Register.username);
        infoDialog.bodyweightOutput.setText(Double.toString(Register.bodyweight));
        infoDialog.convOutput.setText(Register.conv);
        infoDialog.genderOutput.setText(Register.genderName);
        //infoDialog.bodyweightOutput.setText(Macr.calories);
        accessBasicInfoDialog(infoDialog);
    }
    private void onA3Button() { accessCalculatorsDialog(calcDialog);}
    private void onA4Button() { accessCalendarDialog(calendarDialog);}
    private void onA5Button() { accessTrackerDialog(trackerDialog);}
    private void onA6Button() { accessLogoutDialog();}


    private void accessBasicInfoDialog(SeeInfoGUI x){
        x.pack();
        x.setVisible(true);
    }

    private void accessCalculatorsDialog(CalculatorsGUI x){
        x.pack();
        x.setVisible(true);
    }

    private void accessCalendarDialog(planGUI x){
        x.pack();
        x.setVisible(true);
    }

    private void accessTrackerDialog(MacroTrackerGUI x){
        x.pack();
        x.setVisible(true);
    }

    private void accessLogoutDialog(){
        MacroGUI.fat = 0;
        MacroGUI.carb = 0;
        MacroGUI.protein = 0;

        this.dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException {
        HomeScreenGui dialog = new HomeScreenGui();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
