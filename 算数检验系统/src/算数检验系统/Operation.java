package ��������ϵͳ;

import java.util.Date;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Operation {
	private static final String String = null;
	static int first,second,result;//������
	static int biaoda,x;//�ڼ�λ
	static int guize;//���ŵ�ѡ��
	private static int score;
	static String name;
	static float mingxi[];
	static int a,b;//�𰸿⣬�����
	static int n,duitishu;//��������������
	static int daanku[],datiku[];
	static Date date=new Date();
	public static void main (String args[]) throws IOException {
		
        Scanner sc = new Scanner(System.in);

		System.out.println("��ӭʹ����������ϵͳ!");
		System.out.println("����������������:");
		Scanner scan = new Scanner(System.in);
        name = sc.nextLine();
		System.out.println("��ӭ"+name+"ʹ����������ϵͳ!");
		n = 0;
		a=0;
		b=0;
		duitishu = 0;
		int i;
		int choose=menu();
		while(choose!=5) {
			switch(choose) {
			case 1:
				System.out.println("��������Ŀ����:");
				n = scan.nextInt();
				daanku = new int [20];
				int daanku[] = null;
				for(i=0; i<n ; i++ ) {
					chuti();
				}
					break;//����
			case 2:
				datiku = new int [20];
				int datiku[] = null;
				for(i=0; i<n ; i++ ) {
					dati();
				}
					;break;//����
			case 3:checkscore();break;//�鿴�ɼ�
			case 4:rank();break;//���а�
			case 5:break;//�˳�
			default:System.out.println("��Ч��ѡ��");
			}
			choose = menu();
		}
		System.out.println("��л����ʹ��!");	
	}
	
	
	public static int menu() {//�����˵�
		int choose = 0;
		System.out.println("����ݱ��������Ҫ���еĲ���");
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.�鿴�ɼ�");
		System.out.println("4.���а�");
		System.out.println("5.�˳�");
		System.out.println("====================");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();
		
		return choose;
	}
	
	public static int chuti(){//����
		int f;
		f=(int)(1+Math.random()*(4-1+1));
		first = (int)(1+Math.random()*(9-1+1));
		second = (int)(1+Math.random()*(9-1+1));
		switch(f) {
		case 1:System.out.println(first+"+"+second+"=");//�ӷ�
		daanku[a] = first + second;
		break;
		case 2:System.out.println(first+"-"+second+"=");//����
		daanku[a] = first - second;
		break;
		case 3:System.out.println(first+"*"+second+"=");//�˷�
		daanku[a] = first * second;
		break;
		case 4:System.out.println(first+"/"+second+"=");//����
		daanku[a] = first / second;
		break;
		}
		a = a + 1;
		return daanku[a];
	}
	
	public static int dati() throws IOException{//����
		System.out.println("���������Ĵ�:");
		Scanner scan = new Scanner(System.in);
		result = scan.nextInt();
		datiku[b] = result;
		if(datiku[b] == daanku[b]) {
			System.out.println("�ش���ȷ!");
			duitishu = duitishu +1;
		}
		else {
			System.out.println("�ش����");
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
        out.write("���\t\t"+"����\t\t"+"�ɼ�\t"+"ʱ��\t");
        out.newLine();
        out.flush();
        //�������ϰ����ݴ浽�ı��ļ���ȥ
        int index=1;
		for (Student student : set) {
            out.write((index++)+"\t\t"+name+"\t\t"+score+"\t\t"+date);
            out.newLine();
            out.flush();
        }
		
        out.close();
		
		
		
		
		
		return duitishu;

	}
	

	public static void checkscore(){//�鿴�ɼ�
		score = duitishu * 100 / n;

		System.out.println("���ĳɼ�Ϊ:"+score);
		for(int i=0;i<n;i++) {
			System.out.println("��ȷ��Ϊ:"+daanku[i]+";���Ĵ�Ϊ:"+datiku[i]);
		}
	}
	
	public static void rank() {
		System.out.println("��ǰ�ɼ���������:");
		System.out.println("1."+name+"����:"+score+"����ʱ��:"+date.toString());
	}
	
	
	
	
	
	
	

}
