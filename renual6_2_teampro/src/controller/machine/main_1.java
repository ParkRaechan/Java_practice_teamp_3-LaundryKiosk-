package controller.machine;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.MediaView;

public class main_1 implements Initializable{
	
	 @FXML
	 private MediaView webview;

	 @FXML
	 private Button bunstart;

	 @FXML
	 void start(ActionEvent event) {
		 Main.main.loadpage("/view/user/6��������(����â)���.fxml");
		 Main.main.loadpage2("/view/user/6��������(����â)�ϴ�.fxml");
//		 Main.main.loadpage("/view/user/2���������(��ȭ��ȣ).fxml");
//		 Main.main.loadpage2("/view/user/2�������ϴ�(��ȭ���).fxml");
	 }
	 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
 
   
}