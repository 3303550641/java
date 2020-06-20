package 算数检验系统;

import java.util.Date;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Operation {
	private static final String String = null;
	static int first,second,result;//运算数
	static int biaoda,x;//第几位
	static int guize;//符号的选定
	private static int score;
	static String name;
	static float mingxi[];
	static int a,b;//答案库，答题库
	static int n,duitishu;//答题数，对题数
	static int daanku[],datiku[];
	static Date date=new Date();
	public static void main (String args[]) throws IOException {
		
        Scanner sc = new Scanner(System.in);

		System.out.println("欢迎使用算数考试系统!");
		System.out.println("首先请您输入姓名:");
		Scanner scan = new Scanner(System.in);
        name = sc.nextLine();
		System.out.println("欢迎"+name+"使用算数考试系统!");
		n = 0;
		a=0;
		b=0;
		duitishu = 0;
		int i;
		int choose=menu();
		while(choose!=5) {
			switch(choose) {
			case 1:
				System.out.println("请输入题目数量:");
				n = scan.nextInt();
				daanku = new int [20];
				int daanku[] = null;
				for(i=0; i<n ; i++ ) {
					chuti();
				}
					break;//出题
			case 2:
				datiku = new int [20];
				int datiku[] = null;
				for(i=0; i<n ; i++ ) {
					dati();
				}
					;break;//答题
			case 3:checkscore();break;//查看成绩
			case 4:rank();break;//排行榜
			case 5:break;//退出
			default:System.out.println("无效的选择");
			}
			choose = menu();
		}
		System.out.println("感谢本次使用!");	
	}
	
	
	public static int menu() {//操作菜单
		int choose = 0;
		System.out.println("请根据编号输入想要进行的操作");
		System.out.println("1.出题");
		System.out.println("2.答题");
		System.out.println("3.查看成绩");
		System.out.println("4.排行榜");
		System.out.println("5.退出");
		System.out.println("====================");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();
		
		return choose;
	}
	
	public static int chuti(){//出题
		int f;
		f=(int)(1+Math.random()*(4-1+1));
		first = (int)(1+Math.random()*(9-1+1));
		second = (int)(1+Math.random()*(9-1+1));
		switch(f) {
		case 1:System.out.println(first+"+"+second+"=");//加法
		daanku[a] = first + second;
		break;
		case 2:System.out.println(first+"-"+second+"=");//减法
		daanku[a] = first - second;
		break;
		case 3:System.out.println(first+"*"+second+"=");//乘法
		daanku[a] = first * second;
		break;
		case 4:System.out.println(first+"/"+second+"=");//除法
		daanku[a] = first / second;
		break;
		}
		a = a + 1;
		return daanku[a];
	}
	
	public static int dati() throws IOException{//答题
		System.out.println("请输入您的答案:");
		Scanner scan = new Scanner(System.in);
		result = scan.nextInt();
		datiku[b] = result;
		if(datiku[b] == daanku[b]) {
			System.out.println("回答正确!");
			duitishu = duitishu +1;
		}
		else {
			System.out.println("回答错误");
		}
		b = b +1;
		
        TreeSet<Student> set= new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num =o1.getscore()-o2.getscore();
                int num2=num==0?o1.getName().compareTo(o2.getName()):num;
                return num2;
            }
        });
        for(int q=0;q<1;q++) {
        Student student = new Student();
        Student.setName(name);
        Student.setScore(score);
		set.add(student);}
		
		
        BufferedWriter out = new BufferedWriter(new FileWriter("studentScore.txt",true));
        out.write("序号\t\t"+"姓名\t\t"+"成绩\t"+"时间\t");
        out.newLine();
        out.flush();
        //遍历集合把数据存到文本文件中去
        int index=1;
		for (Student student : set) {
            out.write((index++)+"\t\t"+name+"\t\t"+score+"\t\t"+date);
            out.newLine();
            out.flush();
        }
		
        out.close();
		
		
		
		
		
		return duitishu;

	}
	

	public static void checkscore(){//查看成绩
		score = duitishu * 100 / n;

		System.out.println("您的成绩为:"+score);
		for(int i=0;i<n;i++) {
			System.out.println("正确答案为:"+daanku[i]+";您的答案为:"+datiku[i]);
		}
	}
	
	public static void rank() {
		System.out.println("当前成绩排名如下:");
		System.out.println("1."+name+"分数:"+score+"测试时间:"+date.toString());
	}
	
	
	
	
	
	
	

}
