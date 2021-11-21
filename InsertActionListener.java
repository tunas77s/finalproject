package project02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;


public class InsertActionListener implements ActionListener {
		JTextField nameText, addressText, phonenoText; //JTextField ����
	
		InsertActionListener(JTextField nameText, JTextField addressText, JTextField phonenoText) {
			this.nameText = nameText;
			this.addressText = addressText;
			this.phonenoText = phonenoText;
		}
		public void actionPerformed(ActionEvent e) {
			Connection conn = null;
			PreparedStatement ps = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "ysu","1234"); 
	        	String sql= "INSERT INTO studentinfo VALUES(?, ?, ?)"; 
		       	ps=conn.prepareStatement(sql); 
		       	 
		       	ps.setString(1, nameText.getText()); //name���� ��
		       	ps.setString(2, addressText.getText()); //address�� ��
		        ps.setString(3, phonenoText.getText()); //phoneno�� ��
		       	 
		       	ps.executeUpdate();
		    	System.out.println("DB �߰� �Ϸ�\n");
	        }
                
	            
	        catch (ClassNotFoundException cnfe) {
	        	System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." +	cnfe.getMessage());
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
