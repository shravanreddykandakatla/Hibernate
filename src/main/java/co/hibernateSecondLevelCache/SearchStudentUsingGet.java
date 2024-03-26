package co.hibernateSecondLevelCache;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SearchStudentUsingGet {
    public static void main(String[] args) {
        //Second level cache using EHcache
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session1=sfactory.openSession();
        Session session2=sfactory.openSession();
        System.out.println("enter student ID: ");
        Integer sid=sc.nextInt();
        Student student=session1.get(Student.class,sid);
        System.out.println(student);

        try{
            Thread.sleep(2000);
        }catch (Exception ex){

        }

        Student student2=session2.get(Student.class,sid);
        System.out.println(student2);

        System.out.println("------------------------------------------------------");
        session1.close();
        session2.close();
        sfactory.close();
    }
}
