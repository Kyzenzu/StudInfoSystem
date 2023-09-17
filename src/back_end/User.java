package back_end;

import java.util.ArrayList;


public class User {
	private String Username;
	private String Password;
	private ArrayList<String> classes;
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String toString() {
		return Username + "  " + Password;
	}
	
	public void setClasses(ArrayList<String> c) {
		if (c == null) {
			classes = new ArrayList<String>();
			return;
		}
		for (int i = 0; i < c.size(); i++) {
			String str = c.get(i);
			for (int j = i + 1; j < c.size(); j++) 
				if (str.equals(c.get(j)))
					c.remove(j);
		}
		classes = c;
	}
	
	public void addClass(String s) {
		for (int i = 0; i < classes.size(); i++)
			if (s.equals(classes.get(i)))
				return;
		classes.add(s);
	}
	
	public ArrayList<String> getClasses() {
		return classes;
	}
	
	public String getFirstClass() {
		if (classes.size() != 0)
			return classes.get(0);
		return null;
	}
	
	public User(String username,String password){
		super();
		Username = username;
		Password = password;
		classes = new ArrayList<String>();
	}	
	public User(String username,String password, ArrayList<String> c){
		super();
		Username = username;
		Password = password;
		setClasses(c);
	}
	public User(String username,String password, String[] c){
		super();
		Username = username;
		Password = password;
		classes = new ArrayList<String>();
		for (int i = 0; i < c.length; i++)
			classes.add(c[i]);
	}	

}