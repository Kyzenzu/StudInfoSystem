package back_end;

import java.util.ArrayList;
import java.sql.*;

public class UserService{
	private MySQL db;
	
	public UserService(String db_name) {
		db = new MySQL(db_name);
		db.init();
	}
	
	public void close() {
		db.close();
	}
	
	public ArrayList<User> readAll(){
		ArrayList<User> list = new ArrayList<>();
		String sql = "SELECT username, password FROM userInfo";
		db.setsql(sql);
		
		try {
			db.setStatement();
			ResultSet resultSet = db.getStatement().executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString("username");
				String password = resultSet.getString("password");
				User user = new User(name, password);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public boolean verifyUser(User user) {
		ArrayList<User> list = readAll();
		for (User u : list) 
		{
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
				return true;
		}         
		return false;
	}
	
	public boolean verifyUserName(User user) {
		ArrayList<User> list = readAll();
		for(User u : list)
		{
			if(u.getUsername().equals(user.getUsername()))
				return true;
		}          
		return false;
	}

	public boolean store(ArrayList<User> list) {
		boolean flag=false;
		String sql = null;
		try {
			for (User user : list) {
				db.setStatement();
				String name = user.getUsername();
				String password = user.getPassword();
				if (verifyUserName(user)) {
					System.out.println(String.format("'%s', 用户名重复,添加失败", name));
					continue;
				}
				sql = String.format("INSERT INTO userInfo VALUES(0, '%s', '%s')", name, password);
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

	public boolean addUser(User user) {
		boolean flag = false;
		if (verifyUserName(user))
			return flag;
		else {
			String sql = null;
			try {
				db.setStatement();
				String name = user.getUsername();
				String password = user.getPassword();
				StringBuffer sb = new StringBuffer("");
				ArrayList<String> c = user.getClasses();
				for (int i = 0; i < c.size(); i++) {
					sb.append(c.get(i));
					if (i != c.size() - 1)
						sb.append(",");
				}
				String classes = sb.toString();
				sql = String.format("INSERT INTO userInfo VALUES(0, '%s', '%s', '%s')", name, password, classes);
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
	
	public boolean addUser(User user, String[] c) {
		boolean flag = false;
		if (verifyUserName(user))
			return flag;
		else {
			String sql = null;
			try {
				db.setStatement();
				String name = user.getUsername();
				String password = user.getPassword();
				StringBuffer sb = new StringBuffer("");
				for (int i = 0; i < c.length; i++) {
					sb.append(c[i]);
					if (i != c.length - 1)
						sb.append(",");
				}
				String classes = sb.toString();
				sql = String.format("INSERT INTO userInfo VALUES(0, '%s', '%s', '%s')", name, password, classes);
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
	
	public boolean updateClasses(User u) {
		boolean flag = false;
		String sql = null;
		try {
			db.setStatement();
			String username = u.getUsername();
			StringBuffer sb = new StringBuffer("");
			ArrayList<String> c = u.getClasses();
			for (int i = 0; i < c.size(); i++) {
				sb.append(c.get(i));
				if (i != c.size() - 1)
					sb.append(",");
			}
			String classes = sb.toString();
			sql = String.format("UPDATE userInfo set classes = '%s' where username = '%s'", classes, username);
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

	public boolean deleteUser(User user) {
		String sql = null;
		boolean flag = false;
		try {
			db.setStatement();
			String name = user.getUsername();
			sql = String.format("DELETE FROM userInfo WHERE username = '%s'", name);
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
	
	public boolean updatePassword(User oldUser,String password) {
		boolean flag = false;
		String sql = null;
		try {
			db.setStatement();
			String name = oldUser.getUsername();
			sql = String.format("UPDATE userInfo set password = '%s' where username = '%s'", password, name);
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
	
	public User getUser(User u) {
		String sql = String.format("SELECT username, password, classes FROM userInfo WHERE username = '%s'", u.getUsername());
		db.setsql(sql);
		
		try {
			db.setStatement();
			ResultSet resultSet = db.getStatement().executeQuery(sql);
			resultSet.next();
			String name = resultSet.getString("username");
			String password = resultSet.getString("password");
			ArrayList<String> classes;
//			String s = resultSet.getString("classes");
//			System.out.println(resultSet.getString("classes"));
			if (!resultSet.getString("classes").equals("")) {
				String[] c = resultSet.getString("classes").split(",");
				classes = disposeClasses(c);
			} else {
				classes = null;
			}
			u = new User(name, password, classes);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<String> disposeClasses(String[] str) {
		ArrayList<String> c = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			c.add(str[i]);
		}
		return c;
	}
	
	public static void main(String[] args) {
		String db_name = "newInfoSystem";
		UserService us = new UserService(db_name);
		String[] c = new String[3];
		c[0] = "软工22-2";
		c[1] = "软工22-4";
		c[2] = "软工22-5";
		User u1 = new User("root", "root");
		us.addUser(u1, c);
		us.close();
	}
}