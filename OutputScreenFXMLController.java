package project2999;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javax.swing.JFileChooser;

public class OutputScreenFXMLController implements Initializable {

    @FXML
    private TextArea plan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void getData(double salary, double goal, double expense, int time) {
        String s;
        String plans;
        double total = Math.round((salary - expense) * time);
        double leftOver = total - goal;
        double saveAmnt = goal / time;
        
        if(total == goal) {
            s = "Goal will be met exactly.";
        }
        else if(total > goal) {
            s = "Goal will be met with $" + String.format("%.2f",leftOver) + " left.";
        }
        else
            s = "Goal cannot be met with plan. Try another plan.";
        
        String monthlyIncome = "Your monthly income is: $" + String.format("%.2f",salary);
        String monthlyExpenses = "Your monthly expenses are: $" + String.format("%.2f",expense);
        String savingsGoal = "Your savings goal is $" + String.format("%.2f",goal);
        
        plans = "To save $" +  String.format("%.2f",goal) + " in " + time
                + " months, you must save $" +  String.format("%.2f",saveAmnt) + " a month. \n"
                + "Results based on input data: " + s;
        
        String p = monthlyIncome + "\n" + monthlyExpenses + "\n" + savingsGoal + "\n" + plans;
        
        plan.setText(p);
        
    }

    @FXML
    private void printToFile(ActionEvent event) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        
        int choice = fileChooser.showSaveDialog(null);
        
        if(choice == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            FileWriter writer = new FileWriter(file);
            writer.write(plan.getText());
            writer.close();
        }
    }
    
}
