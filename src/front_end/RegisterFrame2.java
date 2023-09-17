package front_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import back_end.*;

public class RegisterFrame2 implements ActionListener {
	private RegisterFrame registerFrame;
	private User user;
	private JFrame frame;
	private Container container;
	private JLabel label;
	private JButton backBtn;
	private JButton registBtn;
	private ArrayList<JCheckBox> checkBoxes;
	
	public RegisterFrame2() {
		frame = new JFrame();
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setTitle("选择班级");
		frame.setBounds(0, 0, 358, 220);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		checkBoxes = new ArrayList<JCheckBox>();
		
		label = new JLabel();
		label.setText("请选择班级:");
		label.setBounds(35, 30, 67, 23);
		container.add(label);
		
		JCheckBox checkBox1 = new JCheckBox("软工22-1");
		checkBox1.setBounds(104, 32, 75, 23);
		checkBoxes.add(checkBox1);
		container.add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("软工22-2");
		checkBox2.setBounds(175, 32, 75, 23);
		checkBoxes.add(checkBox2);
		container.add(checkBox2);
		
		JCheckBox checkBox3 = new JCheckBox("软工22-3");
		checkBox3.setBounds(104, 60, 75, 23);
		checkBoxes.add(checkBox3);
		container.add(checkBox3);
		
		JCheckBox checkBox4 = new JCheckBox("软工22-4");
		checkBox4.setBounds(175, 60, 75, 23);
		checkBoxes.add(checkBox4);
		container.add(checkBox4);
		
		JCheckBox checkBox5 = new JCheckBox("软工22-5");
		checkBox5.setBounds(104, 88, 75, 23);
		checkBoxes.add(checkBox5);
		container.add(checkBox5);
		
		backBtn = new JButton();
		backBtn.setText("上一步");
		backBtn.setBounds(5, 155, 71, 23);
		backBtn.addActionListener(this);
		container.add(backBtn);
		
		registBtn = new JButton();
		registBtn.setText("注册");
		registBtn.setBounds(270, 155, 70, 23);
		registBtn.addActionListener(this);
		container.add(registBtn);
		
		frame.setVisible(true);
	}
	
	public RegisterFrame2(RegisterFrame reFrame, User u) {
		registerFrame = reFrame;
		user = u;
		frame = new JFrame();
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setTitle("选择班级");
		frame.setBounds(0, 0, 358, 220);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		checkBoxes = new ArrayList<JCheckBox>();
		
		label = new JLabel();
		label.setText("请选择班级:");
		label.setBounds(35, 30, 67, 23);
		container.add(label);
		
		JCheckBox checkBox1 = new JCheckBox("软工22-1");
		checkBox1.setBounds(104, 32, 75, 23);
		checkBoxes.add(checkBox1);
		container.add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("软工22-2");
		checkBox2.setBounds(175, 32, 75, 23);
		checkBoxes.add(checkBox2);
		container.add(checkBox2);
		
		JCheckBox checkBox3 = new JCheckBox("软工22-3");
		checkBox3.setBounds(104, 60, 75, 23);
		checkBoxes.add(checkBox3);
		container.add(checkBox3);
		
		JCheckBox checkBox4 = new JCheckBox("软工22-4");
		checkBox4.setBounds(175, 60, 75, 23);
		checkBoxes.add(checkBox4);
		container.add(checkBox4);
		
		JCheckBox checkBox5 = new JCheckBox("软工22-5");
		checkBox5.setBounds(104, 88, 75, 23);
		checkBoxes.add(checkBox5);
		container.add(checkBox5);
		
		backBtn = new JButton();
		backBtn.setText("上一步");
		backBtn.setBounds(5, 155, 71, 23);
		backBtn.addActionListener(this);
		container.add(backBtn);
		
		registBtn = new JButton();
		registBtn.setText("注册");
		registBtn.setBounds(270, 155, 70, 23);
		registBtn.addActionListener(this);
		container.add(registBtn);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new RegisterFrame2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {
			this.frame.setVisible(false);
			registerFrame.getFrame().setVisible(true);
		}
		if (e.getSource() == registBtn) {
			UserService us = new UserService("newInfoSystem");
			ArrayList<String> c = new ArrayList<String>();
			for (JCheckBox box : checkBoxes) 
				if (box.isSelected())
					c.add(box.getText());
			user.setClasses(c);
			us.addUser(user);
			JOptionPane.showMessageDialog(null, "注册成功，点击返回登录", "注册成功", -1);
			frame.setVisible(false);
			new LoginFrame();
		}
	}

}
