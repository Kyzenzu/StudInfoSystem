package front_end;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import back_end.*;

public class AddStudentFrame implements ActionListener{
	private JFrame frame;
	private Container container;
	private JLabel lblStu_id;
	private JLabel lblName;
	private JLabel lblScore;
	private JTextField txtStu_id;
	private JTextField txtName;
	private JTextField txtScore;
	private JButton addBtn;
	private StuInfoList stuInfoList;
	private ListModel listModel;
	
	public AddStudentFrame(StuInfoList sil) {
		stuInfoList = sil;
		this.listModel = sil.getListModel();
		frame = new JFrame("添加学生");
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setBounds(100, 100, 358, 220);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setLocationRelativeTo(null);    
	    
		lblStu_id = new JLabel();
		lblStu_id.setBounds(155, 15, 100, 15);
		lblStu_id.setText("学号");
		container.add(lblStu_id);
		
		lblName = new JLabel();
		lblName.setBounds(155, 55, 100, 15);
		lblName.setText("姓名");
		container.add(lblName);
		
		lblScore = new JLabel();
		lblScore.setBounds(155, 95, 100, 15);
		lblScore.setText("成绩");
		container.add(lblScore);
		
		txtStu_id = new JTextField();
		txtStu_id.setBounds(95, 32, 150, 20);
		container.add(txtStu_id);
		
		txtName = new JTextField();
		txtName.setBounds(95, 72, 150, 20);
		container.add(txtName);
		
		txtScore = new JTextField();
		txtScore.setBounds(95, 112, 150, 20);
		container.add(txtScore);
		
		addBtn = new JButton();
		addBtn.setText("添加");
		addBtn.setBounds(132, 145, 70, 23);
		addBtn.addActionListener(this);
		container.add(addBtn);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			String stu_id = txtStu_id.getText().trim();
			String name = txtName.getText().trim();
			String Stringscore = txtScore.getText().trim();
			if (!stu_id.equals("") && !name.equals("") && !Stringscore.equals("")) {
				String regex1 = "\\d+";
				Pattern pattern1 = Pattern.compile(regex1);
				Matcher matcher1 = pattern1.matcher(Stringscore);
				if (matcher1.matches()) {
					int score = Integer.parseInt(Stringscore);
					String regex = "[0-9]{4}[a-z][0-9]{5}";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(stu_id);
					if (matcher.matches()) {
						if (score >= 0 && score <= 100) {
							Student stu = new Student(stu_id, name, score);
							StudentService ss = new StudentService("newInfoSystem", stuInfoList.getClassName());
							if (ss.addStudent(stu)) {
								listModel.addElement(stu);
								JOptionPane.showMessageDialog(frame, "添加成功", "消息", -1);
							} else {
								JOptionPane.showMessageDialog(frame, "学号已存在", "添加失败", 0);
							}
						} else {
							JOptionPane.showMessageDialog(frame, "成绩设置不正确", "添加失败", 0);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "学号格式不正确", "添加失败", 0);
					}		
				} else {
					JOptionPane.showMessageDialog(frame, "成绩设置不正确", "添加失败", 0);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "请输入完整数据", "添加失败", 0);
			}
		}
	}

	
	public static void main(String[] args) {
	}
	


}
