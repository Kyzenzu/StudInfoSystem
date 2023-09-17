package front_end;

import java.awt.*;
import javax.swing.*;
import back_end.*;

public class LoginFrame {
	private JFrame frame;
	private Container container;
	private JLabel accountLbl;
	private JLabel passwordLbl;
	private JTextField accountTxt;
	private JPasswordField passwordTxt;
	private JButton loginBtn;
	private JButton registerBtn;
	
	public LoginFrame() {
		frame = new JFrame();
		frame.setTitle("登陆界面");
		container = frame.getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 360, 179);
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
		
		loginBtn = new JButton();
		loginBtn.setBounds(100, 106, 70, 23);
		loginBtn.setText("登录");
		loginBtn.addActionListener(e -> {
			String name = accountTxt.getText().trim();
			String password = new String(passwordTxt.getPassword());
			User user = new User(name, password);
			UserService us = new UserService("newInfoSystem");
			if (us.verifyUser(user)) {
				frame.setVisible(false);
				user = us.getUser(user);
				new MainFrame(user);
			} else {
				accountTxt.setText("");
				passwordTxt.setText(""); 
				JOptionPane.showMessageDialog(frame, "用户名或密码错误", "登陆失败", 0);
			}
		});
		container.add(loginBtn);
		
		registerBtn = new JButton();
		registerBtn.setBounds(190, 106, 70, 23);
		registerBtn.setText("注册");
		container.add(registerBtn);
		registerBtn.addActionListener(e -> {
			new RegisterFrame();
			frame.setVisible(false);
		});
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}
