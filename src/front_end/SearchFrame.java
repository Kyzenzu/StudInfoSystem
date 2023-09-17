package front_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import back_end.*
;

public class SearchFrame implements ActionListener{
	private JFrame frame;
	private Container container;
	private JLabel lblStu_id;
	private JLabel lblName;
	private JTextField txtStu_id;
	private JTextField txtName;
	private JButton searchBtn;
	private StuInfoList stuInfoList;
	
	public SearchFrame(StuInfoList stuInfoList) {
		this.stuInfoList = stuInfoList;
		frame = new JFrame();
		frame.setTitle("查找界面");
		frame.setBounds(100, 100, 335, 220);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    container = frame.getContentPane();
	    container.setLayout(null);
	    
	    lblStu_id = new JLabel();
	    lblStu_id.setText("学号:");
	    lblStu_id.setBounds(85, 30, 50, 15);
	    container.add(lblStu_id);
	    
	    lblName = new JLabel();
	    lblName.setText("姓名:");
	    lblName.setBounds(85, 75, 50, 15);
	    container.add(lblName);
	    
	    txtStu_id = new JTextField();
	    txtStu_id.setBounds(120, 30, 100, 20);
	    container.add(txtStu_id);
	    
	    txtName = new JTextField();
	    txtName.setBounds(120, 75, 100, 20);
	    container.add(txtName);
	    
	    searchBtn = new JButton();
	    searchBtn.setText("查询");
	    searchBtn.setBounds(115, 120 ,72, 23);
	    searchBtn.addActionListener(this);
	    container.add(searchBtn);
	    
	    frame.setVisible(true);
	}
	
	public void selectItemList(Student stu) {
		JList<Student> list = stuInfoList.getList();
		DefaultListModel<Student> listModel = stuInfoList.getListModel();
		int size = listModel.getSize();
		for (int i = 0; i < size; i++) {
			Student s = listModel.getElementAt(i);
			if (stu.equals(s)) {
				list.setSelectedIndex(i);
				list.ensureIndexIsVisible(i);
				frame.setVisible(false);
	            return;
			}
		}
		JOptionPane.showMessageDialog(frame, "未查询到该学生", "查询失败", 0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchBtn) {
			String stu_id = txtStu_id.getText().trim();
			String name = txtName.getText().trim();
			if (!stu_id.equals("") && !name.equals("")) {
				Student stu = new Student(stu_id, name, 0);
				selectItemList(stu);
			} else {
				JOptionPane.showMessageDialog(frame, "请输入完整数据", "查询失败", 0);
			}
		}
	}
	
	public static void main(String[] args) {
	}



}
