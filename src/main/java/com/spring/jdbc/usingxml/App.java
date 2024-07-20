package com.spring.jdbc.usingxml;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class App {
	
	public static int insert(JdbcTemplate template , Student student) {
		String query = "insert into student(id,name,city,district,state) values (?,?,?,?,?)";
		int r = template.update(query,student.getId(),student.getName(),student.getCity(),student.getDistrict(),student.getState());
		return r;
	}
	
	public static int update(String query , JdbcTemplate template , String data , int id) {
		int r = template.update(query,data,id);
		return r;
	}
	
	public static void updateColumn(String query , JdbcTemplate template) {
		template.update(query);
	}
	
	public static Student getStudent(String query , JdbcTemplate template) {
		RowMapper<Student> mapper = new RowMapperImplementation();
		Student student = template.queryForObject(query , mapper);
		return student;
	}
	
	public static List<Student> getAllStudent(String query , JdbcTemplate template) {
		RowMapper<Student> mapper = new RowMapperImplementation();
		List<Student> student = template.query(query , mapper);
		return student;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("./config.xml");
		JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate","JbbcTemplate.class");
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(" 1 for Insert Student Data .");
	    	System.out.println(" 2 for Update Student Name .");
	    	System.out.println(" 3 for Update Student City .");
	    	System.out.println(" 4 for Update Student District .");
	    	System.out.println(" 5 for Update Student State .");
	    	System.out.println(" 6 for Modify Column => Add Column .");
	    	System.out.println(" 7 for Modify Data => Inser Data in newly created Column .");
	    	System.out.println(" 8 for Modify Data => Modify Column Type .");
	    	System.out.println(" 9 for Modify Data => Rename Column .");
	    	System.out.println(" 10 for Modify Data => Drop Column .");
	    	System.out.println(" 11 for Modify Data => Rename Table using Alter Command .");
	    	System.out.println(" 12 for Truncate Table .");
	    	System.out.println(" 13 for Rename Table .");
	    	System.out.println(" 14 for Delete Data .");
	    	System.out.println(" 15 for Display Desired Data .");
	    	System.out.println(" 16 for Display All Data .");
	    	System.out.println(" 17 for Exit .");
	    	System.out.println("Choose Option ----------->");
	    	
	    	int choice = sc.nextInt();
	    	
	    	switch(choice) {
	    	
	    		case 1 : 		Student student1 = new Student();
	    		
	    						System.out.println("Enter Id : ");
	    						int id = sc.nextInt();
	    						student1.setId(id);
	    						
	    						sc.nextLine();
	    						
	    						System.out.println("Enter Name : ");
	    						String name = sc.nextLine();
	    						student1.setName(name);
	    						
	    						
	    						
	    						System.out.println("Enter City : ");
	    						String city = sc.nextLine();
	    						student1.setCity(city);
	    						
	    						System.out.println("Enter District : ");
	    						String district = sc.nextLine();
	    						student1.setDistrict(district);
	    						
	    						System.out.println("Enter State : ");
	    						String state = sc.nextLine();
	    						student1.setState(state);
	    						
	    						int r1 = insert(template, student1);
	    						System.out.println("Data Inserted : "+ r1 + " row");
	    						
	    						break;
	    						
	    		case 2 :		
								System.out.println("Enter Name : ");
								String name1 = sc.next();
								
								
								System.out.println("Enter Id : ");
								int id1 = sc.nextInt();								
								
								String query = "update student set name = ? where id = ?";
								
								int r2 = update(query , template, name1 , id1);
								System.out.println("Student Name Updated : "+ r2 + " row");
								
								break;
								
	    		case 3 :		
				    			System.out.println("Enter City : ");
								String city1 = sc.next();
								
								System.out.println("Enter Id : ");
								int id2 = sc.nextInt();		
								
								String query1 = "update student set city = ? where id = ?";
								
								int r3 = update(query1, template , city1 , id2);
								System.out.println("Student City Updated : "+ r3 + " row");
								
								break;
								
	    		case 4 :		
				    			System.out.println("Enter District : ");
								String district1 = sc.next();
								
								System.out.println("Enter Id : ");
								int id3 = sc.nextInt();		
								
								String query2 = "update student set district = ? where id = ?";
								
								int r4 = update(query2, template , district1 , id3);
								System.out.println("Student District Updated : "+ r4 + " row");
								
								break;
								
	    		case 5 :		
				    			System.out.println("Enter State : ");
								String state1 = sc.next();							
								
								System.out.println("Enter Id : ");
								int id4 = sc.nextInt();		
								
								String query3 = "update student set state = ? where id = ?";
								
								int r5 = update(query3, template , state1 , id4);
								System.out.println("Student District Updated : "+ r5 + " row");
								
								break;
								
	    		case 6 :		
				    			System.out.println("Enter Column Name for varchar type : ");
								String columnName = sc.next();							
								
								System.out.println("Enter Column Type as varchar(255) ");
								String columnType = sc.next();	
								
								String query4 = String.format("alter table student add column %s %s" , columnName , columnType);
								
								updateColumn(query4, template);
								
								System.out.println("Column Added Successed .");
								
								break;
								
	    		case 7 :		
				    			System.out.println("Enter Data for newly created column : ");
								String columnData = sc.next();							
								
								System.out.println("Enter Id : ");
								int id5 = sc.nextInt();	
								
								String query5 = "update student set village = ? where id = ?";
								
								int r6 = update(query5, template , columnData , id5);
								
								System.out.println("Student Data Updated : "+ r6 + " row");
								
								break;
								
								
	    		case 8 :		
				    			System.out.println("Enter Column Name : ");
								String columnName1 = sc.next();					
								
								System.out.println("Enter Column Type : ");
								String columnType1 = sc.next();
								
								String query6 = String.format("alter table student modify column %s %s" , columnName1 , columnType1);
								
								updateColumn(query6, template);
								
								System.out.println("Column Modified Successed .");
								
								break;
								
								
	    		case 9 :		
				    			System.out.println("Enter old Column Name To Rename : ");
								String oldname = sc.next();	
								System.out.println("Enter new Column Name  : ");
								String newname = sc.next();	
								String query7 = String.format("alter table student rename column %s to %s",oldname,newname);
								
								updateColumn(query7, template);
								
								System.out.println("Column Modified Successed .");
								
								break;
								
								
	    		case 10 :		
				    			System.out.println("Enter Column Name To Drop : ");
								String colname = sc.next();	
								
								String query8 = String.format("alter table student drop column %s",colname);
								
								updateColumn(query8, template);
								
								System.out.println("Column Droped Successed .");
								
								break;
								
								
	    		case 11 :		System.out.println("Enter old Table Name : ");
								String old_name = sc.next();
								
								System.out.println("Enter new Table Name : ");
								String new_name = sc.next();
								
								String query9 = String.format("alter table %s rename to %s",old_name,new_name);
								
								updateColumn(query9, template);
								
								System.out.println("Table Rename Successed .");
								
								break;
								
								
	    		case 12 :		System.out.println("Enter Table Name : ");
								String t_name = sc.next();
								
								String query10 = String.format("truncate table %s",t_name);
								
								updateColumn(query10, template);
								
								System.out.println("Table Truncate Successed .");
								
								break;
								
								
	    		case 13 :		System.out.println("Enter old Table Name : ");
								String od_name = sc.next();
								
								System.out.println("Enter new Table Name : ");
								String nw_name = sc.next();
								
								String query11 = String.format("rename table %s to %s",od_name,nw_name);
								
								updateColumn(query11, template);
								
								System.out.println("Table Rename Successed .");
								
								break;
								
								
	    		case 14 :		System.out.println("Enter Id : ");
								int id6 = sc.nextInt();								
								
								String query12 = String.format("delete from student where id = %d",id6);
								
								updateColumn(query12, template);
								
								System.out.println("Table Data Deleted Successed .");
								
								break;
								
								
	    		case 15 :		System.out.println("Enter Id : ");
								int id7 = sc.nextInt();								
								
								String query13 = String.format("select * from student where id = %d",id7);
								
								Student student = getStudent(query13, template);
								
								System.out.println("Student Data : "+student);
								
								break;
								
								
	    		case 16 :							
								
								String query14 = "select * from student";
								
								List<Student> allstudent = getAllStudent(query14, template);
								
								System.out.println("Student Data : "+allstudent);
								
								break;
								
								
	    		case 17 :		System.exit(0);
	    						break;
	    						
	    						
	    		default:	System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
							break;
								
	    	}					
		}
		
	}
}
