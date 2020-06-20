package 算数检验系统;

import java.util.Date;

public class Student {
	private static int score;
	static String name;
	static Date date=new Date();
	
	
    public int getscore() {
        return score;
    }
    public static  void setName(String name) {
    	Student.name = name;
    }
    public String getName() {
    	return name;
    }
    public Date getdate() {
    	return date;
    }
    public static void setScore(int score) {
    	Student.score = score;
    }
    public static void setdate(Date date) {
    	Student.date = date;
    }
}