package FitnessApp;

import javax.swing.*;
import java.awt.event.*;

public class WilksGUI extends JDialog {
    private JPanel contentPane;
    private JButton calculateWilksButton;
    private JLabel wilksOutput;
    public JLabel bodyweightInput;
    public JLabel genderInput;
    private JTextField squatInput;
    private JTextField benchInput;
    private JTextField deadliftInput;
    public JLabel convInput;
    private double g,h,i,j,k,l;


    public WilksGUI() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);

        calculateWilksButton.addActionListener(e -> {
            double conversion;

            String conv = convInput.getText();
            if(conv.equals("lbs")){
                conversion = 2.204;
            } else {
                conversion = 1;
            }

            double total = (Double.parseDouble(squatInput.getText())/conversion)
                    + (Double.parseDouble(benchInput.getText())/conversion)
                    + (Double.parseDouble(deadliftInput.getText())/conversion);

            String gender = genderInput.getText();
            double bodyweight = (Double.parseDouble(bodyweightInput.getText())/conversion);

            setCoefficients(gender);

            double wilks = total * (500 / (
                            (g * Math.pow(bodyweight,0)) +
                            (h * Math.pow(bodyweight,1)) +
                            (i * Math.pow(bodyweight,2)) +
                            (j * Math.pow(bodyweight,3)) +
                            (k * Math.pow(bodyweight,4)) +
                            (l * Math.pow(bodyweight,5))));

            wilksOutput.setText(Double.toString(Math.round(wilks)));
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

    void setCoefficients(String gender){
        if(gender.equals("boy")){
            g = -216.0475144;
            h = 16.2606339;
            i = -0.002388645;
            j = -0.00113732;
            k = 7.01863E-06;
            l = -1.291E-08;
        } else {
            g = 594.31747775582;
            h = -27.23842536447;
            i = 0.82112226871;
            j = -0.00930733913;
            k = 0.00004731582;
            l = -0.00000009054;
        }
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
        WilksGUI dialog = new WilksGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
