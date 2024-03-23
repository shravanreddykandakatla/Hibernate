package co.hibernateFirstLevelCache;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SearchStudentUsingGet {
    public static void main(String[] args) {
        //Hibernate provides the first level cache by default but after closing the session the data is lost
        //Using get if you search for record which doesn't exist it will return null.
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();
        System.out.println("enter student ID: ");
        Integer sid=sc.nextInt();
        Student student=session.get(Student.class,sid);
        System.out.println(student);

        try{
            Thread.sleep(2000);
        }catch (Exception ex){

        }
        //when it searches for the same ID again it won't create aand execute query it will get the data from session created cache
        Student student2=session.get(Student.class,sid);
        System.out.println(student);

        System.out.println("------------------------------------------------------");
        session.close();
        sfactory.close();
    }
}
