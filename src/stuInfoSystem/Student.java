package stuInfoSystem;

public class Student {
	private String Stu_id;
	private String Name;
	private String Score;

	public String getStu_id() {
		return Stu_id;
	}

	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}

	public Student(String stu_id,String name,String score) {
		super();
		Stu_id = stu_id;
		Name = name;
   		Score = score;
	}

}