package project01;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ContactInfoFinder2 extends JFrame {
	
	public ContactInfoFinder2() {
		setTitle("연락처 검색 프로그램");
		setPreferredSize(new Dimension(500, 200));
		setLocation(500, 400);
		Container contentPane = getContentPane();
		JTextField text1 = new JTextField(6);
		JTextField text2 = new JTextField(10);
		JTextField text3 = new JTextField(5);
		JButton button = new JButton("검색");
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("수정");
		JButton button3 = new JButton("삭제");
		JPanel panel = new JPanel();
		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("주소"));
		panel.add(text2);
		panel.add(new JLabel("전화번호"));
		panel.add(text3);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		contentPane.add(panel, BorderLayout.NORTH);
		String colNames[] = { "이름", "주소", "전화번호" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		button.addActionListener(new SearchActionListener2(table, text1, text2, text3));
		button1.addActionListener(new InsertActionListener2(text1, text2, text3));
		button2.addActionListener(new UpdateActionListener2(text1, text2, text3));
		button3.addActionListener(new DeleteActionListener2(text1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ContactInfoFinder2();
	}
}
