package com.ty;

import java.util.Scanner;

public class Student
{
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		 Studentinterface  s1 =new Studentimpl();
		 while (true)
		 {
			 System.out.println("1:savestudent\n2:deletestudent\n3:updatestudent\n4:getstudentbymarks\n5:getAllstudent\n6:Exit");
			 System.out.println("enter a choice");
			 int choice = sc.nextInt();
			 switch(choice)
			 {
			 case 1:
			      s1.saveStudent();
			      break;
			 case 2:
				 s1.deleteStudent();
				 break;
			 case 3:
				 s1.updateStudent();
				 break;
			 case 4:
				 s1.getStudentbymarks();
				 break;
			 case 5:
				 s1.getAllStudent();
				 break;
			 case 6:
				 System.exit(0);
			default:
				System.out.println("invalid choice");
				 
			 }
		 }
		
		
	}

}
