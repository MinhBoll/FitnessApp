package FitnessApp;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class planGUI extends JDialog {
    private JPanel contentPane;
    private JButton planButton;
    private JTextField planField;
    private JButton setNewDayButton;
    private JComboBox dayBox;
    private JLabel dayLabel;
    private JButton addButton;
    private JComboBox exerciseBox;
    private JButton delButton;
    private JTextField temField;

    protected final static String MESS_1 = "You are new!";
  //  protected final static String FILE_NAME = "src/FitnessApp/info.txt";

    private ArrayList<String> plan = new ArrayList<String>();
    private ArrayList<String> monday = new ArrayList<String>();
    private ArrayList<String> tuesday = new ArrayList<String>();
    private ArrayList<String> wednesday = new ArrayList<String>();
    private ArrayList<String> thursday = new ArrayList<String>();
    private ArrayList<String> friday = new ArrayList<String>();
    private ArrayList<String> saturday = new ArrayList<String>();
    private ArrayList<String> sunday = new ArrayList<String>();
    private String line;
    FileWriter fileWriter;

    public planGUI() {
        setContentPane(contentPane);
        setModal(true);

        planButton.addActionListener(e -> {
            try {
                // TODO add your handling code here:
                File file = new File("src/FitnessApp/"+Register.username+"info.txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                if (fr.read() == -1) {
                    this.planField.setText(MESS_1);
                } else {
                    planField.read(br, null);
                    br.close();
                    planField.requestFocus();
                }
            } catch (IOException ex) {
              //  this.planField.setText(MESS_1);
            }
        });

        dayBox.addActionListener(e -> {
            String day = dayBox.getSelectedItem().toString();
            this.dayLabel.setText("You are on " + day);
        });


        addButton.addActionListener(e -> {
            String day = dayBox.getSelectedItem().toString();
            temField.setText(addData(day));
        });

        delButton.addActionListener(e -> {
            String day = dayBox.getSelectedItem().toString();
            temField.setText(delData(day));
        });



        setNewDayButton.addActionListener(e -> {
            try {
                BufferedWriter reader = new BufferedWriter(new FileWriter(new File("src/FitnessApp/"+Register.username+"info.txt"), true));
             //   BufferedReader br = new BufferedReader(new FileReader(new File(FILE_NAME)));

                //Scanner scan = new Scanner(FILE_NAME);

                reader.write(temField.getText());
               // replaceLine(temField.getText());
                reader.newLine();

                reader.close();
            } catch (IOException exc) {
                System.out.println(exc);
            }
            try {
                // TODO add your handling code here:
                File file = new File("src/FitnessApp/"+Register.username+"info.txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                planField.read(br, null);
                br.close();
                planField.requestFocus();
            } catch (IOException ex) {
                this.planField.setText(MESS_1);
            }
            this.exerciseBox.setSelectedItem("");
            this.plan.clear();
            this.dayBox.setSelectedItem("");
            this.dayLabel.setText("");
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

    public ArrayList<String> delArr(ArrayList<String> plan){
        String ex1 = exerciseBox.getSelectedItem().toString();
        for(int i=0;i<plan.size();i++){
            if(ex1.equals(plan.get(i))){
                plan.remove(i);
            }
        } return plan;
    }

    public String addData(String name){
        String ex = exerciseBox.getSelectedItem().toString();
        String line2 = null;

        switch (name) {
            case "MONDAY":
                this.monday.add(ex);
                this.line = name+"|"+monday.toString().replaceAll("\\[\\]","");
                break;
            case "TUESDAY":
                this.tuesday.add(ex);
                this.line = name+"|"+tuesday.toString().replaceAll("\\[\\]","");
                break;
            case "WEDNESDAY":
                this.wednesday.add(ex);
                this.line = name+"|"+wednesday.toString().replaceAll("\\[\\]","");
                break;
            case "THURSDAY":
                this.thursday.add(ex);
                this.line = name+"|"+thursday.toString().replaceAll("\\[\\]","");
                break;
            case "FRIDAY":
                this.friday.add(ex);
                this.line = name+"|"+friday.toString().replaceAll("\\[\\]","");
                break;
            case "SATURDAY":
                this.saturday.add(ex);
                this.line = name+"|"+saturday.toString().replaceAll("\\[\\]","");
                break;
            case "SUNDAY":
                this.sunday.add(ex);
                this.line = name+"|"+sunday.toString().replaceAll("\\[\\]","");
                break;
            default:

                break;
        } line2 = this.line;
        return line2;
    }
    public String delData(String name){
        String line3 = null;

        switch (name) {
            case "MONDAY":
                this.line = name+"|"+delArr(monday).toString().replaceAll("\\[\\]","");
                break;
            case "TUESDAY":
                this.line = name+"|"+delArr(tuesday).toString().replaceAll("\\[\\]","");
                break;
            case "WEDNESDAY":
                this.line = name+"|"+delArr(wednesday).toString().replaceAll("\\[\\]","");
                break;
            case "THURSDAY":
                this.line = name+"|"+delArr(thursday).toString().replaceAll("\\[\\]","");
                break;
            case "FRIDAY":
                this.line = name+"|"+delArr(friday).toString().replaceAll("\\[\\]","");
                break;
            case "SATURDAY":
                this.line = name+"|"+delArr(saturday).toString().replaceAll("\\[\\]","");
                break;
            case "SUNDAY":
                this.line = name+"|"+delArr(sunday).toString().replaceAll("\\[\\]","");
                break;
            default:

                break;
        } line3 = this.line;
        return line3;
    }
 /*   public void replaceLine(String newLine) throws IOException {
        Scanner scan = new Scanner(new File("src/FitnessApp/"+Register.username+"info.txt"));

        String oldLine ="";
        while(scan.hasNextLine()){
            oldLine = scan.nextLine();
            if(oldLine.contains(dayBox.getSelectedItem().toString())){
                newLine = oldLine.replaceAll(oldLine,newLine);
            }FileWriter wr = new FileWriter("src/FitnessApp/"+Register.username+"info.txt");
            wr.write(newLine);
            wr.close();
        }
    }*/

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        planGUI dialog = new planGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
