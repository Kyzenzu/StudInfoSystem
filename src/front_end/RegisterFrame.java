package front_end;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import back_end.*;

public class RegisterFrame {
	private JFrame frame;
	private Container container;
	private JLabel accountLbl;
	private JLabel passwordLbl;
	private JLabel repasswordLbl;
	private JTextField accountTxt;
	private JPasswordField passwordTxt;
	private JPasswordField repasswordTxt;
	private JButton nextBtn;
	private JButton backBtn;
	
	public RegisterFrame() {
		frame = new JFrame();
		frame.setTitle("注册界面");
		container = frame.getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 360, 210);
		frame.setLocationRelativeTo(null);

		
		accountLbl = new JLabel();
		accountLbl.setBounds(100, 23, 42, 15);
		accountLbl.setText("账号:");
		container.add(accountLbl);
		
		accountTxt = new JTextField();
		accountTxt.setBounds(146, 20, 96, 21);
		accountTxt.setColumns(15);
		container.add(accountTxt);
		
		passwordLbl = new JLabel();
		passwordLbl.setBounds(100, 65, 42, 15);
		passwordLbl.setText("密码:");
		container.add(passwordLbl);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(145, 62, 96, 21);
		//passwordTxt.setEchoChar('*');
		passwordTxt.setColumns(15);
		container.add(passwordTxt);
		
		repasswordLbl = new JLabel();
		repasswordLbl.setBounds(75, 100, 60, 15);
		repasswordLbl.setText("重复密码:");
		container.add(repasswordLbl);
		
		repasswordTxt = new JPasswordField();
		repasswordTxt.setBounds(146, 100, 96, 21);
		//passwordTxt.setEchoChar('*');
		repasswordTxt.setColumns(15);
		container.add(repasswordTxt);
		
		nextBtn = new JButton();
		nextBtn.setBounds(260, 140, 71, 23);
		nextBtn.setText("下一步");
		container.add(nextBtn);
		nextBtn.addActionListener(e -> {
			String name = accountTxt.getText().trim();
			String password = new String(passwordTxt.getPassword());
			String repassword = new String(repasswordTxt.getPassword());
			if (name.equals("") || password.equals("") || repassword.equals("")) {
				JOptionPane.showMessageDialog(frame, "请输入完整数据", "注册失败", 0);
				return;
			}
			User user = new User(name, password);
			UserService us = new UserService("newInfoSystem");
			if (us.verifyUserName(user)) {
				accountTxt.setText("");
				passwordTxt.setText("");
				repasswordTxt.setText("");
				JOptionPane.showMessageDialog(frame, "用户名已存在，请重新输入", "注册失败", 0);
			} else {
				if (!password.equals(repassword)) {
					passwordTxt.setText(""); 
					repasswordTxt.setText("");
					JOptionPane.showMessageDialog(frame, "密码不一致，请重新输入", "注册失败", 0);
				} else {				
					frame.setVisible(false);
					new RegisterFrame2(this, user);
				}
			}
		});
		
		backBtn = new JButton();
		backBtn.setText("返回");
		backBtn.setBounds(3, 143, 59, 20);
		backBtn.addActionListener(e -> {
			frame.setVisible(false);
			new LoginFrame();
		});
		container.add(backBtn);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JFrame getFrame() {
		return frame;
	}
	public static void main(String[] args) {
		new RegisterFrame();
	}
		
}
