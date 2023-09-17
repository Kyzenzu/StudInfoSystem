package stuInfoSystem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentService{

	public ArrayList<Student>  readAll(){
		ArrayList<Student> list=new ArrayList<>();
		BufferedReader out;
		try {
			out=new BufferedReader(new FileReader("./src/service/Goal.txt"));
			String s="";
			String[] arr=null;
			while((s=out.readLine())!=null)
			{
				arr=s.split(",");
				Student goal=new Student(arr[0],arr[1],arr[2]);
				list.add(goal);
			}
			}
		catch 
		     (IOException e){e.printStackTrace();}
		     return list;
	}

	
public boolean store(ArrayList<Student>list)
{
boolean flag=false;
try
{
      FileWriter out=new FileWriter("./src/service/Goal.txt");
      String name="";
      String stu_id="";
      String score="";
      for(Student a:list)
{
      name=a.getName();
    score=a.getScore();
    stu_id=a.getStu_id();
      out.write(stu_id+","+name+","+score);
      out.write("\n");
}
      out.flush();
      out.close();
      flag=true;
}
     catch(Exception e)
{
      e.printStackTrace();

}
      return flag;
}


//public boolean verifyUser(Goal goal) {
	//ArrayList<Goal> list=readAll();
	//for(Goal u:list) 
	//{
	//	if(u.getName().equals(goal.getName())&&u.getScore().equals(goal.getScore()))
           //      return true;
	//}         
	//return false;
//}
public boolean verifyStu_id(Student goal){
	ArrayList<Student> list=readAll();
    for(Student u:list)
    {
	if(u.getStu_id().equals(goal.getStu_id()))
             return true;
}          
    return false;
	
}

public boolean addGoal(Student goal) {
	if(verifyStu_id(goal))
		return false;
	else {
		ArrayList<Student> list=readAll();
		list.add(goal);
		store(list);
		return true;
	}
}


public boolean deleteGoal(Student goal) {
	ArrayList<Student> list=readAll();
	for(Student u:list) {
		if(u.getStu_id().equals(goal.getStu_id())&&u.getName().equals(goal.getName())&&u.getScore().equals(goal.getScore()))
		{
			list.remove(u);
			store(list);
			return true;
		}
	}
	return false;
}
 public boolean updateScore(Student goal,String score) {
		ArrayList<Student> list=readAll();
		for(Student u:list) {
			if(u.getStu_id().equals(goal.getStu_id())&&u.getName().equals(goal.getName())&&u.getScore().equals(goal.getScore()))
	{
		 list.remove(u);
		 list.add(new Student(goal.getStu_id(),goal.getName(),score));
	      store(list);
	      return true;
	      }}
		return false;
 }



public static void main(String[] args) {
	StudentService us=new StudentService();
	//ArrayList<Goal> list=us.readAll();
	//if(us.updateScore(new Goal("2022","u1","33"),"56"))
	//	System.out.println("ok");
	//else
		//System.out.println("no");}}
Student goal=new Student("2022","u1","56");

	//if(us.verifyStu_id(goal))
//System.out.println("no");
//else {
//ArrayList<Goal> list=us.readAll();
//list.add(goal);
//us.store(list);
//System.out.println("yes");
     us.deleteGoal(goal);}}
     
