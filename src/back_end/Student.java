package back_end;

public class Student implements Comparable<Student>{
	private String Stu_id;
	private String Name;
	private int Score;
	private String belongClass;

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

	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public void setBelongClass(String bclass) {
		belongClass = bclass;
	}
	public String getBelongClass() {
		return belongClass;
	}
	public String toString() {
		String str = Stu_id + "  " + Name;
		return str;
	}

	public Student(String stu_id,String name,int score) {
		super(); 
		Stu_id = stu_id;
		Name = name;
   		Score = score;
	}
	
	public Student(String stu_id,String name,int score, String bclass) {
		Stu_id = stu_id;
		Name = name;
   		Score = score;
   		belongClass = bclass;
	}

	@Override
	public int compareTo(Student o) {
		char c1 = 'b';
		char c2 = 'a';
		for (int i = 0; i < Stu_id.length(); i++) {		
			if (Stu_id.charAt(i) >= 'a' && Stu_id.charAt(i) <= 'z') {
				c1 = Stu_id.charAt(i);
				break;
			}
		}
		for (int i = 0; i < o.Stu_id.length(); i++) {		
			if (o.Stu_id.charAt(i) >= 'a' && o.Stu_id.charAt(i) <= 'z') {
				c2 = o.Stu_id.charAt(i);
				break;
			}
		}
		String b1 = Character.toString(c1);
		String b2 = Character.toString(c2);

		int n1 = Integer.parseInt(this.Stu_id.split(b1)[0]);
//		System.out.println(o.Stu_id.split(b2)[0]);
		int n2 = Integer.parseInt(o.Stu_id.split(b2)[0]);
		int n3 = Integer.parseInt(this.Stu_id.split(b1)[1]);
		int n4 = Integer.parseInt(o.Stu_id.split(b2)[1]);
		if (n1 != n2)
			return n1 - n2;
		else 
			return n3 - n4;
	}
	
	public boolean equals(Student other) {
		if (this.Stu_id.equals(other.Stu_id) && this.Name.equals(other.Name))
			return true;
		return false;
	}

}