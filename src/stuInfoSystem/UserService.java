package stuInfoSystem;

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
			String s = "";
			String[] arr = null;
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
	
	public boolean vertifyUser(User user) {
		ArrayList<User> list = readAll();
		for(User u:list) 
		{
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
				return true;
		}         
		return false;
	}
	
	public boolean vertifyUserName(User user) {
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
				String name = user.getUsername();
				String password = user.getPassword();
				if (vertifyUserName(user)) {
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
		if (vertifyUserName(user))
			return flag;
		else {
			String sql = null;
			try {
				String name = user.getUsername();
				String password = user.getPassword();
				sql = String.format("INSERT INTO userInfo VALUES(0, '%s', '%s')", name, password);
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

	public boolean deleteUser(User user) {
		String sql = null;
		boolean flag = false;
		try {
			Statement statement = db.getStatement();
			String name = user.getUsername();
			String password = user.getPassword();
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
			Statement statement = db.getStatement();
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

	public static void main(String[] args) {
		String db_name = "stuInfoSystem";
		UserService us = new UserService(db_name);
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("ww", "xxxxx"));
		list.add(new User("ff", "xxxxx"));
		us.store(list);
		User user = new User("aa", "aaaaa");
		us.deleteUser(user);
		ArrayList<User> users = us.readAll();
		for (User u : users) {
			System.out.println(u.getUsername() + ": " + u.getPassword());
		}
		us.close();
	}
}