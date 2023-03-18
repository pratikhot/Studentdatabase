package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Studentimpl implements Studentinterface
{
	Scanner scanner =new Scanner(System.in);

	@Override
	public void saveStudent() 
	{
		System.out.println("Enter the student id");
		int id =scanner.nextInt();
		System.out.println("Enter the student name");
		String name =scanner.next();
		System.out.println("Enter the student age");
		int age =scanner.nextInt();
		System.out.println("Enter the student marks");
		double marks =scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
			PreparedStatement preparedstatement =connection.prepareStatement("insert into Student values(?,?,?,?)");
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setInt(3, age);
			preparedstatement.setDouble(4, marks);

			preparedstatement.execute();
			connection.close();
			System.out.println("**********************DATA SAVED SUCCESSFULLY **************************");		
			}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void deleteStudent() 
	{
		System.out.println(" enter student id to be deleted");
		int id= scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Student where id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.execute();
			connection.close();
			System.out.println("**********************DATA DELETED SUCCESSFULLY **************************");			
			} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent()
	{
		while(true) {
			System.out.println("1:update name\n2:update age\n3:update marks\n4:Exit");
			System.out.println("Enter a choice");
			int choice =scanner.nextInt();

			switch(choice) 
			{
			case 1:
				System.out.println("Enter student id: ");
				int id = scanner.nextInt();
				System.out.println(" Enter student name: ");
				String name = scanner.next();
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
					PreparedStatement preparedStatement = connection.prepareStatement("update Student set name=? where id=?");
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, id);

					preparedStatement.execute();
					connection.close();
					System.out.println("**********************DATA UPDATED SUCCESSFULLY **************************");			
				}

				catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter student id: ");
				int id1 = scanner.nextInt();
				System.out.println(" Enter student age: ");
				int  age = scanner.nextInt();
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
					PreparedStatement preparedStatement = connection.prepareStatement("update Student set age=? where id=?");
					preparedStatement.setInt(1, age);
					preparedStatement.setInt(2, id1);
					preparedStatement.execute();
					connection.close();
					System.out.println("**********************DATA UPDATED SUCCESSFULLY **************************");			
				}

				catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter student id: ");
				int id2 = scanner.nextInt();
				System.out.println(" Enter student marks: ");
				double marks = scanner.nextDouble();
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
					PreparedStatement preparedStatement = connection.prepareStatement("update Student set marks=? where id=?");
					preparedStatement.setDouble(1, marks);
					preparedStatement.setInt(2, id2);
					preparedStatement.execute();
					connection.close();
					System.out.println("**********************DATA UPDATED SUCCESSFULLY **************************");

				}

				catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("THANK YOU!!!!!!!");
				System.exit(0);
				

			default:
				System.out.println("IVALID CHOICE !!!");
			}
		}
	}

	@Override
	public void getStudentbymarks()
	{
		System.out.println(" enter the marks:");
		double marks=scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Student  where marks=? ");
			preparedStatement.setDouble(1, marks);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next())
			{
				System.out.println("The student id is :"+resultset.getInt(1));
				System.out.println("The student name is: "+resultset.getString(2));
				System.out.println("The student  age: "+resultset.getInt(3));
				System.out.println("The student marks is: "+resultset.getDouble(4));

			}
			connection.close();
			System.out.println("**************** DATA  RETRIVED SUCCESSFULLY ********************");
		} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void getAllStudent()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Student   ");
           ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next())
			{
				System.out.println("The student id is :"+resultset.getInt(1));
				System.out.println("The student name is: "+resultset.getString(2));
				System.out.println("The student  age is : "+resultset.getInt(3));
				System.out.println("The student marks is: "+resultset.getDouble(4));
				System.out.println("*************************************");
			}
			
			connection.close();
			System.out.println("*********************DATA  RETRIVED SUCCESSFULLY **********************");

		} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
