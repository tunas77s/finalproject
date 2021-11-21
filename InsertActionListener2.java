package project02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;


public class InsertActionListener2 implements ActionListener {
		JTextField text1, text2, text3; //JTextField 생성
	
		InsertActionListener2(JTextField text1, JTextField text2, JTextField text3) {
			this.text1 = text1;
			this.text2 = text2;
			this.text3 = text3;
		}
		public void actionPerformed(ActionEvent e) {
			Connection conn = null;
			PreparedStatement ps = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "ysu","1234"); //여기까지 db연결
	        	String sql= "INSERT INTO studentinfo VALUES(?, ?, ?)"; //sql문 작성
		       	ps=conn.prepareStatement(sql); //sql문을 데이터베이스 테이블로 넘겨줌
		       	 
		       	ps.setString(1, text1.getText()); //name으로 들어감
		       	ps.setString(2, text2.getText()); //address로 들어감
		        ps.setString(3, text3.getText()); //phoneno로 들어감
		       	 
		       	ps.executeUpdate();
		    	System.out.println("DB 추가 완료\n");
	        }
                
	            
	        catch (ClassNotFoundException cnfe) {
	        	System.out.println("해당 클래스를 찾을 수 없습니다." +	cnfe.getMessage());
	        }
	        catch(SQLException se) {
	        	System.out.println(se.getMessage());
	        }
	        finally {
	        	try {
	        		ps.close();
	        	}
	        	catch (Exception ignored) {
	        	}
	        	try {
	        		conn.close();
	        	}
	        	catch (Exception ignored) {
	        	}
	        }
	    }    
}
