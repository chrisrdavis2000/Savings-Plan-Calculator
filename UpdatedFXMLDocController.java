package project2999;

import UserData.UserDataClass;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class UpdatedFXMLDocController implements Initializable {

    @FXML
    private TextField incomeBox, savingBox, necBox;
    @FXML
    private RadioButton threeMonth, sixMonth, twlvMonth;
    @FXML
    private ToggleGroup toggle;
    @FXML
    private Button genPlan;
    
    UserDataClass user = new UserDataClass();
    @FXML
    private Label incomeError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selected(ActionEvent event) {
        if(threeMonth.isSelected()) {
            user.setTime(3);
        }
        else if(sixMonth.isSelected()) {
            user.setTime(6);
        }
        else
            user.setTime(12);
    }

    @FXML
    private void genPlanPressed(ActionEvent event) throws IOException {
        //setInfo();
        try {
            setInfo();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OutputScreenFXML.fxml"));
            Parent root = loader.load();
        
            OutputScreenFXMLController outputController = loader.getController();
            outputController.getData(user.getIncome(), user.getGoal(), user.getExpenses(), user.getTime());
        
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(NumberFormatException e) {
            incomeError.setText("Invalid input or blank field");
        }
    }
    
    public void setInfo() throws IOException {
        user.setIncome(Double.parseDouble(incomeBox.getText()));
        user.setGoal(Double.parseDouble(savingBox.getText()));
        user.setExpenses(Double.parseDouble(necBox.getText()));
    }
}
