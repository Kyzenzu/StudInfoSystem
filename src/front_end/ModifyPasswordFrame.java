package front_end;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import back_end.*;

public class ModifyPasswordFrame extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	JLabel lblPassword;
	JLabel lblNewPassword;
	JLabel lblRePassword;
	JPasswordField pswPassword;
	JPasswordField pswNewPassword;
	JPasswordField pswRePassword;
	JLabel lblAccount;
	JTextField txtAccount;
	JButton modiBtn;
	JButton backBtn;
	Container c;
	private User user;
	
	public ModifyPasswordFrame(User user) {
		this.user = user;
		
		frame = new JFrame("修改密码");
		Container c = frame.getContentPane();
		c.setLayout(null);
		frame.setBounds(100, 100, 358, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setLocationRelativeTo(null);
	    
		lblAccount = new JLabel();
		lblAccount.setBounds(100, 23, 100, 15);
		lblAccount.setText("用户名: "+ user.getUsername());
		c.add(lblAccount);
		
		lblPassword = new JLabel();
		lblPassword.setBounds(100,45,50,15);
		lblPassword.setText("原密码: ");
		c.add(lblPassword);
		
		lblNewPassword = new JLabel();
		lblNewPassword.setBounds(100, 67, 50, 15); 
		lblNewPassword.setText("新密码: ");
		c.add(lblNewPassword);
		
		lblRePassword = new JLabel();
		lblRePassword.setBounds(100, 89, 58, 15);
		lblRePassword.setText("重复密码: ");
		c.add(lblRePassword);
		
		pswPassword = new JPasswordField();
		pswPassword.setBounds(145,42,96,21);
		pswPassword.setColumns(15);
		//pswPassword.setEchoChar('*');
		c.add(pswPassword);
		
		pswNewPassword = new JPasswordField();
		pswNewPassword.setBounds(145, 65, 96, 21);
		pswNewPassword.setColumns(15);
		c.add(pswNewPassword);
		
		pswRePassword = new JPasswordField();
		pswRePassword.setBounds(157, 88, 84, 21);
		pswRePassword.setColumns(15);
		//pswPassword.setEchoChar('*');
		c.add(pswRePassword);
		
		modiBtn = new JButton();
		modiBtn.setBounds(128, 122, 70, 25);
		modiBtn.setText("修改");
		modiBtn.addActionListener(this);
		c.add(modiBtn);
		
		backBtn = new JButton();
		backBtn.setBounds(7, 138, 59, 20);
		backBtn.setText("返回");
		backBtn.addActionListener(this);
		c.add(backBtn);
		
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modiBtn) {		
			UserService us = new UserService("stuInfoSystem");
			String username = user.getUsername();
			String password = new String(pswPassword.getPassword());
			User u = new User(username, password);
			if (us.verifyUser(u)) {
				String newPassword = new String(pswNewPassword.getPassword());
				String rePassword = new String(pswRePassword.getPassword());
				if (newPassword.equals(rePassword)) {
					if (us.updatePassword(u, newPassword)) {
						JOptionPane.showMessageDialog(this, "修改成功,请重新登录", "消息", 1);
						frame.setVisible(false);
						new LoginFrame();
					} else {
						JOptionPane.showMessageDialog(this, "修改失败", "未知错误", 0);
						pswPassword.setText("");
						pswNewPassword.setText("");
						pswRePassword.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(this, "密码不一致,请重新输入", "修改失败", 0);
					pswPassword.setText("");
					pswNewPassword.setText("");
					pswRePassword.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(this, "原密码错误", "修改失败", 0);
				pswPassword.setText("");
				pswNewPassword.setText("");
				pswRePassword.setText("");
			}
		}
		if (e.getSource() == backBtn) {
			frame.setVisible(false);
			new MainFrame(user);
		}
	}
	
	public static void main(String[] args) {
		new ModifyPasswordFrame(new User("admin", "admin"));
	}

}
