package controller.phone;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DialOutput implements Initializable{
	
    @FXML
    private Label phonelbl;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	System.out.println(Main.main.temptable.getMphone() + "�� �缳��");
    	phonelbl.setText(Main.main.temptable.getMphone());
    }
}
