package project01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;

public class DeleteActionListener2 implements ActionListener {
	JTextField text1;
	
	DeleteActionListener2(JTextField text1) {
		this.text1 = text1;
	}
	public void actionPerformed(ActionEvent e) {
		Connection conn = null;
		PreparedStatement ps = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sampledb", "root","");
        	String sql= "DELETE FROM studentinfo WHERE name = ?;";
	       	ps=conn.prepareStatement(sql);
	       	 
	       	ps.setString(1, text1.getText());
	       	
		    ps.executeUpdate();
		    System.out.println("���ڵ� ���� �Ϸ�\n");
	       	
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
