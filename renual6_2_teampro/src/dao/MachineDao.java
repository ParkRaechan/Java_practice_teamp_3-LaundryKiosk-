package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dto.Machine;
import dto.temptable;

public class MachineDao {
	private Connection con; // DB������ ���Ǵ� Ŭ���� : DB����Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽� 
	
	public static MachineDao machinedao = new MachineDao(); // DB ���� ��ü;
	
	public MachineDao() {
		try {
			// DB���� 
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://database-1.ctq8tels7lkd.us-east-1.rds.amazonaws.com:3306/javafx?serverTimezone=UTC",
					"focks","akfrdmsfocks0626!!$LLH"); // 2. DB �ּ� ���� 
		}
		catch(Exception e ) { System.out.println( "[DB ���� ����]"+e  ); }
	}
	//�ӽ� ����
	public boolean update(temptable tb) {
		try {
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); // db date Ÿ�� �°� �ð��̱�
			String sql = "update machine set mamount=?,mphone=?,mtemperature=?,mdegree=?,mtime=? where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, tb.getMamount());
			ps.setString(2, tb.getMphone());
			ps.setString(3, tb.getMtemperature());
			ps.setString(4, tb.getMdegree());
			ps.setTimestamp(5,date);
			ps.setInt(6, tb.getMnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("[sql ����]" + e);
		}
		return false;
	}
	//�ӽ� �ҷ�����
	public Machine load(int mnum) {
		try {
			String sql = "select * from machine where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			Machine machine = null;
			if(rs.next()) {
				LocalDateTime localDate1 = rs.getTimestamp(6).toLocalDateTime();// LocalDateTime <=> Timestamp	
			Machine temp = new Machine(	
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						localDate1,
						0
						);
			machine = temp;
			}
			return machine;
		} catch (Exception e) {
			System.out.println("[sql ����]" + e);
		}
		return null;
	}
	
}