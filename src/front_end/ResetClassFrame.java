package front_end;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import back_end.*;

public class ResetClassFrame implements ActionListener {
	private MainFrame mainFrame;
	private User user;
	private JFrame frame;
	private Container container;
	private JLabel label;
	private JButton resetBtn;
	private ArrayList<JCheckBox> checkBoxes;
	
	public ResetClassFrame() {
		frame = new JFrame();
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setTitle("重置班级");
		frame.setBounds(0, 0, 350, 200);
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
		
		
		resetBtn = new JButton();
		resetBtn.setText("重置");
		resetBtn.setBounds(125, 130, 70, 23);
		resetBtn.addActionListener(this);
		container.add(resetBtn);
		
		frame.setVisible(true);
	}
	
	public ResetClassFrame(MainFrame mFrame, User u) {
		mainFrame = mFrame;
		user = u;
		frame = new JFrame();
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setTitle("重置班级");
		frame.setBounds(0, 0, 350, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		setSelected();
		
		resetBtn = new JButton();
		resetBtn.setText("重置");
		resetBtn.setBounds(125, 130, 70, 23);
		resetBtn.addActionListener(this);
		container.add(resetBtn);
		
		frame.setVisible(true);
	}
	
	public void setSelected() {
		ArrayList<String> c = user.getClasses();
		for (int i = 0; i < checkBoxes.size(); i++) {
			JCheckBox box = checkBoxes.get(i);
			for (int j = 0; j < c.size(); j++) {			
				if (c.get(j).equals(box.getText())) {				
					box.setSelected(true);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ResetClassFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetBtn) {
			UserService us = new UserService("newInfoSystem");
			ArrayList<String> c = new ArrayList<String>();
			for (JCheckBox box : checkBoxes) 
				if (box.isSelected())
					c.add(box.getText());
			user.setClasses(c);
			if (us.updateClasses(user)) {			
				JOptionPane.showMessageDialog(null, "重置成功", "消息", -1);
				mainFrame.getFrame().setVisible(false);
				frame.setVisible(false);
				new MainFrame(user);
			} else {
				JOptionPane.showMessageDialog(frame, "未知错误", "添加失败", 0);
			}
		}
	}

}
