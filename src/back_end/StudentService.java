package back_end;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;


public class StudentService{
	private MySQL db;
	private String table;
	public StudentService (String db_name, String className) {
		db = new MySQL(db_name);
		db.init();
		this.table = disposeTable(className); // 软工22-3
	}
	public StudentService (String db_name) {
		db = new MySQL(db_name);
		db.init();
		//this.table = disposeTable(table);
	}
	public void close() {
		db.close();
	}
	public String disposeTable(String str) {
		if (str != null) {
			String classId = str.split("-")[1];
			return "class" + classId;
		}
		return null;
	}
	public ArrayList<Student> readAll(){
		ArrayList<Student> list = new ArrayList<>();
		String sql = "SELECT stu_id, name, score FROM " + table;
		db.setsql(sql);
		
		try {
			db.setStatement();
			ResultSet resultSet = db.getStatement().executeQuery(sql);
			while (resultSet.next()) {
				String stu_id = resultSet.getString("stu_id");
				String name = resultSet.getString("name");
				int score = resultSet.getInt("score");
				Student stu = new Student(stu_id, name, score);
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return list;
	}
	
	public ArrayList<Student> readAll2(){
		ArrayList<Student> list = new ArrayList<>();
		String sql = "SELECT stu_id FROM allStudents";
		db.setsql(sql);
		
		try {
			db.setStatement();
			ResultSet resultSet = db.getStatement().executeQuery(sql);
			while (resultSet.next()) {
				String stu_id = resultSet.getString("stu_id");
				String name = " ";
				int score = 0;
				Student stu = new Student(stu_id, name, score);
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return list;
	}

	public boolean verifyStu_id(Student stu){
		ArrayList<Student> list = readAll2();
	    for (Student s : list) {
	    		if(stu.getStu_id().equals(s.getStu_id())) {
				//System.out.println(String.format("'%s', 学生已存在,添加失败", s.getStu_id()));		
	    			return true;
	    		}
	    }
	    return false;
	}
	
	public boolean store(ArrayList<Student> list) {
		boolean flag=false;
		String sql = null;
		try {
			for (Student stu : list) {
				db.setStatement();
				String stu_id = stu.getStu_id();
				String name = stu.getName();
				int score = stu.getScore();
				if (verifyStu_id(stu)) {
					continue;
				}
				sql = String.format("INSERT INTO %s VALUES(0, '%s', '%s', %d)", table, stu_id, name, score);
				db.setsql(sql);
				PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
				preparedStatement.executeUpdate();
			}
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeStatement();
		}
		return flag;
	}
	
	public boolean addStudent(Student stu) {
		boolean flag = false;
		if (verifyStu_id(stu))
			return flag;
		else {
			String sql = null;
			try {
				db.setStatement();
				String stu_id = stu.getStu_id();
				String name = stu.getName();
				int score = stu.getScore();
				sql = String.format("INSERT INTO %s VALUES(0, '%s', '%s', %d)", table, stu_id, name, score);
				db.setsql(sql);
				PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
				preparedStatement.executeUpdate();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeStatement();
			}
		}
		return flag;
	}

	public boolean deleteStudent(Student stu) {
		String sql = null;
		boolean flag = false;
		try {
			db.setStatement();
			String stu_id = stu.getStu_id();
			sql = String.format("DELETE FROM %s WHERE stu_id = '%s'", table, stu_id);
			String sql2 = String.format("DELETE FROM allStudents WHERE stu_id = '%s'", stu_id);
			db.setsql(sql);
			PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement = db.getConnection().prepareStatement(sql2);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeStatement();
		}
		return flag;
	}

	public boolean updateScore(Student oldStu,int score) {
		boolean flag = false;
		String sql = null;
		try {
			db.setStatement();
			String stu_id = oldStu.getStu_id();
			sql = String.format("UPDATE %s set score = '%d' where stu_id = '%s'", table, score, stu_id);
			db.setsql(sql);
			PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			db.closeStatement();
		}
		return flag;
	}

	public static void main(String[] args) {
	}
}