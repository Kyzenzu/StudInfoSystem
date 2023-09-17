package front_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import back_end.*;

class ListModel extends DefaultListModel<Student> {
	private static final long serialVersionUID = 1L;
	public void sort() {
		ArrayList<Student> a = new ArrayList<Student>();
		for (int i = 0; i < getSize(); i++)
			a.add(getElementAt(i));
		clear();
		Collections.sort(a);
		for (int i = 0; i < a.size(); i++)
			addElement(a.get(i));
	}
	public ListModel() {
		super();
//		StudentService ss = new StudentService("newInfoSystem"); 
//		ArrayList<Student> students = ss.readAll();
//		for (Student stu : students) 
//			this.addElement(stu);
//		sort();
		
	}
	public ListModel(String className) {
		StudentService ss = new StudentService("newInfoSystem", className); 
		ArrayList<Student> students = ss.readAll();
		for (Student stu : students) 
			this.addElement(stu);
		sort();
		
	}
	public void updataListModel(String className) {
		clear();
		StudentService ss = new StudentService("newInfoSystem", className);
		ArrayList<Student> students = ss.readAll();
		for (Student stu : students)
			this.addElement(stu);
		sort();
	}
}

public class StuInfoList implements ListSelectionListener, ActionListener {
	private MainFrame frame;
	private JList<Student> list;
	private ListModel listModel;
	private Student selectStu;
	private int selectIndex;
	private JButton modiScoreBtn;
	private JButton delStuBtn;
	private String className;
	
	public StuInfoList(MainFrame frame) {
		//listModel = new MyListModel();
		this.frame = frame;
		listModel = new ListModel();
		list = new JList<Student>(listModel);
		Container frameContainer = frame.getContainer();
		list.addListSelectionListener(this);
		frameContainer.add(list);
		
		modiScoreBtn = new JButton();
		modiScoreBtn.setText("点击修改成绩");
		modiScoreBtn.setBounds(230, 29, 150, 20);
		modiScoreBtn.addActionListener(this);
		frameContainer.add(modiScoreBtn);
		
		delStuBtn = new JButton();
		delStuBtn.setText("点击删除学生");
		delStuBtn.setBounds(230, 50, 150, 20);
		delStuBtn.addActionListener(this);
		frameContainer.add(delStuBtn);
		
//		frameContainer.updateUI();
	}
	public StuInfoList(MainFrame frame, String className) {
		//listModel = new MyListModel();
		this.className = className;
		this.frame = frame;
		if (className != null) {
			listModel = new ListModel(className);
		} else {
			listModel = new ListModel();
		}

		list = new JList<Student>(listModel);
		Container frameContainer = frame.getContainer();
		list.addListSelectionListener(this);
		frameContainer.add(list);
		
		modiScoreBtn = new JButton();
		modiScoreBtn.setText("点击修改成绩");
		modiScoreBtn.setBounds(230, 29, 150, 20);
		modiScoreBtn.addActionListener(this);
		frameContainer.add(modiScoreBtn);
		
		delStuBtn = new JButton();
		delStuBtn.setText("点击删除学生");
		delStuBtn.setBounds(230, 50, 150, 20);
		delStuBtn.addActionListener(this);
		frameContainer.add(delStuBtn);
		
//		frameContainer.updateUI();
	}
	public JList<Student> getList() {
		return this.list;
	}
	public ListModel getListModel() {
		return listModel;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String c) {
		className = c;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == list) {
			JTextArea textArea = frame.getTextArea();
			if (list.getSelectedValue() != null) {
				selectStu = list.getSelectedValue();
				selectIndex = list.getSelectedIndex();
				String score = Integer.toString(selectStu.getScore());
//				System.out.println(selectStu);
//				System.out.println(selectIndex);
				textArea.setText(score);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delStuBtn) {
			int n = JOptionPane.showConfirmDialog(null,"确定是否删除","确定界面",JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == 0) {
				if (list.getSelectedIndex() != -1) {
					
					StudentService ss = new StudentService("newInfoSystem", className);
					if (ss.deleteStudent(selectStu)) {
						listModel.remove(selectIndex);
						frame.getTextArea().setText("");
						JOptionPane.showMessageDialog(frame.getFrame(), "删除成功", "删除", -1);
					} else {
						JOptionPane.showMessageDialog(frame.getFrame(), "删除失败", "未知错误", 0);
					}
				}
			}
		}
		if (e.getSource() == modiScoreBtn) {
			int n = JOptionPane.showConfirmDialog(null,"确定是否修改","确定界面",JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == 0) {
				JTextArea textArea = frame.getTextArea();
				if (list.getSelectedIndex() != -1) {
					StudentService ss = new StudentService("newInfoSystem", className);
					int newScore = Integer.parseInt(textArea.getText().trim());
					if (newScore >= 0 && newScore <= 100) {
						if (ss.updateScore(selectStu, newScore)) {
							selectStu.setScore(newScore);
							JOptionPane.showMessageDialog(frame.getFrame(), "修改成功", "修改", -1);
						} else {
							textArea.setText(Integer.toString(selectStu.getScore()));
							JOptionPane.showMessageDialog(frame.getFrame(), "修改失败", "未知错误", 0);
						}
					} else {
						textArea.setText(Integer.toString(selectStu.getScore()));
						JOptionPane.showMessageDialog(frame.getFrame(), "检查分数设置", "修改失败", 0);
					}
				}
			}
		}
	}
}
