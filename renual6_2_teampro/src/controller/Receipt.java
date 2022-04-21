package controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.CategoryDao;
import dao.MachineDao;
import dto.Category;
import dto.Machine;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Receipt implements Initializable{
	 	@FXML
	    private Button btnhome;

	    @FXML
	    private Button btnhome2;

	    @FXML
	    private Label phone;

	    @FXML
	    private Label category;

	    @FXML
	    private Label temperature;

	    @FXML
	    private Label drgree;

	    @FXML
	    private Label starttime;

	    @FXML
	    private Label endtime;

	    @FXML
	    private Label amoment;

	    @FXML
	    void home(ActionEvent event) {
	    	Main.main.loadpage2("/view/user/1��������(����).fxml");
	    	Main.main.temptable.setInputprice(0); // �ݾ� �ʱ�ȭ
	    }
	    @FXML
	    void home2(ActionEvent event) {
	    	Main.main.loadpage2("/view/user/1��������(����).fxml");
	    	Main.main.temptable.setInputprice(0); // �ݾ� �ʱ�ȭ
	    }
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	//db�� ��������
	    		//�ӽ�
	    	Machine machine = MachineDao.machinedao.load(Main.main.temptable.getMnum());
	    		//ī�װ�
	    	Category category = CategoryDao.categoryDao.load(Main.main.temptable.getMnum());
	    	//����ó��
	    	if (machine != null) {
	    		//���̺� ����
		    	phone.setText(machine.getMphone());
		    	//category.setText();
		    	temperature.setText(machine.getMtemperature());
		    	drgree.setText(machine.getMdegree());
		    	//�ð� ��ȯ
		    	String stime = machine.getMtime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		    	starttime.setText(stime);
		    	//����ð� [��Ź 40�� ������ 30��]
		    		//����ð� ���
		    	if(category.getCname().contains("��Ź��")) {
		    		LocalDateTime etime = machine.getMtime().plusMinutes(40); // 40�� ���ϱ�
		    		String etimes = etime.format(DateTimeFormatter.ofPattern("HH:mm"));
		    		endtime.setText(etimes);
		    	}else if(category.getCname().contains("������")) {
		    		LocalDateTime etime = machine.getMtime().plusMinutes(30);// 30�� ���ϱ�
		    		String etimes = etime.format(DateTimeFormatter.ofPattern("HH:mm"));
		    		endtime.setText(etimes);
		    	}
		    	amoment.setText(Integer.toString(category.getCprice()));
	    	}else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("������������ �� ������ �����ߴ�");
	    		alert.show();
	    	}
	    	
//	    	
	    }
}