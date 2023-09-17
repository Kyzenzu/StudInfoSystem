package front_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import back_end.*;

public class SelectClassFrame implements ActionListener{
	private User user;
	private MainFrame mainFrame;
	private JFrame frame;
	private Container container;
	private JLabel lblSelectClass;
	private JComboBox<String> cboxSelectClass;
	private JButton selectBtn;
	
	public SelectClassFrame() {
		frame = new JFrame();
		container = frame.getContentPane();
		frame.setBounds(0, 0, 400, 200);
		frame.setTitle("选择班级");
		container.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblSelectClass = new JLabel();
		lblSelectClass.setText("请选择班级:");
		lblSelectClass.setBounds(80, 30, 67, 15);
		container.add(lblSelectClass);
		
		cboxSelectClass = new JComboBox<String>();
		cboxSelectClass.setBounds(150, 25, 125, 21);
		container.add(cboxSelectClass);
			
		frame.setVisible(true);
	}
	
	public SelectClassFrame(User u) {
		user = u;
		frame = new JFrame();
		container = frame.getContentPane();
		frame.setBounds(0, 0, 325, 150);
		frame.setTitle("选择班级");
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblSelectClass = new JLabel();
		lblSelectClass.setText("当前班级:");
		lblSelectClass.setBounds(50, 30, 67, 15);
		container.add(lblSelectClass);
		
		cboxSelectClass = new JComboBox<String>(getArrayClass());
		cboxSelectClass.setBounds(120, 25, 125, 21);
		container.add(cboxSelectClass);
		
		selectBtn = new JButton();
		selectBtn.setText("选择");
		selectBtn.setBounds(120, 70, 70, 23);
		selectBtn.addActionListener(this);
		container.add(selectBtn);
		
		frame.setVisible(true);
	}
	
	public SelectClassFrame(MainFrame mainFrame, User u) {
		user = u;
		this.mainFrame = mainFrame;
		frame = new JFrame();
		container = frame.getContentPane();
		frame.setBounds(0, 0, 325, 150);
		frame.setTitle("选择班级");
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblSelectClass = new JLabel();
		lblSelectClass.setText("当前班级:");
		lblSelectClass.setBounds(50, 30, 67, 15);
		container.add(lblSelectClass);
				
		cboxSelectClass = new JComboBox<String>(getArrayClass());
		cboxSelectClass.setBounds(120, 25, 125, 21);
		container.add(cboxSelectClass);
		
		selectBtn = new JButton();
		selectBtn.setText("选择");
		selectBtn.setBounds(120, 70, 70, 23);
		selectBtn.addActionListener(this);
		container.add(selectBtn);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		String name = "admin";
		String password = "admin";
		ArrayList<String> c = new ArrayList<String>();
		c.add("软工22-1");
		c.add("软工22-2");
		c.add("软工22-3");
		User u = new User(name, password, c);
		new SelectClassFrame(u);
	}

	public String[] getArrayClass() {
		int size = user.getClasses().size();
		String[] a = new String[size];
		for (int i = 0; i < size; i++)
			a[i] = user.getClasses().get(i);
		return a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String currentClass = (String)cboxSelectClass.getSelectedItem();
//		System.out.println(currentClass);
		StuInfoList sil = mainFrame.getList();
		sil.setClassName(currentClass);
		ListModel listModel = sil.getListModel();
		listModel.updataListModel(currentClass);
		JLabel lblCurClass = mainFrame.getCurrentClass();
		lblCurClass.setText("当前班级: " + currentClass);
		frame.setVisible(false);
	}

}
