package project02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;


public class UpdateActionListener2 implements ActionListener {
		JTextField text1, text2, text3;
	
		UpdateActionListener2(JTextField text1, JTextField text2, JTextField text3) {
			this.text1 = text1;
			this.text2 = text2;
			this.text3 = text3;
		}
		public void actionPerformed(ActionEvent e) {
			Connection conn = null;
			PreparedStatement ps = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sampledb", "root","");
	        	String sql= "update studentinfo set address = ?, phoneno = ? where name = ?;";
		       	ps=conn.prepareStatement(sql);
		       	 
		       	ps.setString(1, text2.getText());
		       	ps.setString(2, text3.getText());
		        ps.setString(3, text1.getText());
		       	 
		       	ps.executeUpdate();
		    	System.out.println("레코드 변경 완료\n");
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
