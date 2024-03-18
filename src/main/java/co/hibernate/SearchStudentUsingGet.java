package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SearchStudentUsingGet {
    public static void main(String[] args) {
        //Using get if you search for record which doesn't exist it will return null.
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();
        System.out.println("enter student ID: ");
        Integer sid=sc.nextInt();
        Student student=session.get(Student.class,sid);
        System.out.println(student);

        System.out.println("------------------------------------------------------");
        session.close();
        sfactory.close();
    }
}
