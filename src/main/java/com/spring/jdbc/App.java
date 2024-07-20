package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        
        StudentDao dao = context.getBean("studentdaoimplement",StudentDao.class);
        
        List<Student> student = dao.getAllStudent();
        for(Student s:student)
        	System.out.println(s);
    }
}
