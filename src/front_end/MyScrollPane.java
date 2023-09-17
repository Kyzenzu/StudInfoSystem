package front_end;

import javax.swing.*;
import back_end.*;

public class MyScrollPane extends JScrollPane{
	private static final long serialVersionUID = 1L;

	public MyScrollPane(JList<Student> list) {
		super(list);
		String titleBorder = "       学号       姓名";
		list.setBorder(BorderFactory.createTitledBorder(titleBorder));
		setBounds(10, 10, 130, 200);
	}
}
