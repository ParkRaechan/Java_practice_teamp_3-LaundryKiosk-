package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MachineDao;
import dto.Category;
import dto.Machine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Payment implements Initializable{
	@FXML
	private Label temperature;

	@FXML
	private Label mdegree;
	
	@FXML
	private Label catagroy;
	 
	@FXML
	private Label mamount;

	@FXML
	private Button btnhome;

	@FXML
	private Button btnaddmoney;

	@FXML
	private Button btnpaymentend;
	
	boolean pass = false; // �ݾ� ���� �Ǵ�
	@FXML
	void addmoney(ActionEvent event) {
		//Main.main.temptable.setWholeprice(5000); �׽�Ʈ
	    if(Main.main.temptable.getWholeprice() > Main.main.temptable.getInputprice()) {//���Աݾ� ������
	    	Main.main.temptable.setInputprice(Main.main.temptable.getInputprice() + 500); //500���߰�
	    	Main.main.loadpage2("/view/user/6��������(����â)�ϴ�.fxml"); // ��ư���������� ���ΰ�ħ
	    }else { // ���Աݾ� ������
	    	pass = true;
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setHeaderText("���Աݾ� �������� ������");
	    	alert.show();
	    }
	}

	@FXML
	void home(ActionEvent event) {
		Main.main.loadpage2("/view/user/1��������(����).fxml");	// �߷��� �Ʒ� �߰� load ���
	}

	@FXML
	void paymentend(ActionEvent event) {
		if(pass) { // ���Աݾ� �������� �� true�̸�
			//db�� ����ֱ�
			Main.main.temptable.setMnum(1);
			Main.main.temptable.setMamount(100);
			Main.main.temptable.setMphone("010-5694-0195");
			Main.main.temptable.setMtemperature("����");
			Main.main.temptable.setMdegree("����");
			MachineDao.machinedao.update(Main.main.temptable);
			Main.main.loadpage2("/view/user/7������(������).fxml");
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setHeaderText("�� �������� �� ������! �Ѥ�");
	    	alert.show();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		temperature.setText(Main.main.temptable.getMtemperature()); //�µ�����
//		mamount.setText(Integer.toString(Main.main.temptable.getWholeprice())); // ���հ���
//		mdegree.setText(Main.main.temptable.getMdegree()); //���⼳��
//		catagroy.setText(Main.main.temptable.getCname()); // catagroy1 �ֱ�
		
	}
}