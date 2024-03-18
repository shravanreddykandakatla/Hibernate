package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class SearchStudentUsingLoad {
    public static void main(String[] args) {
        //Using load if you search for record which doesn't exist it will throw an exception.
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();

        Student student=new Student();
        System.out.println(student);

        try{
            System.out.println("enter student ID: ");
            Integer sid=sc.nextInt();
            session.load(student,sid);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        System.out.println(student);


        System.out.println("------------------------------------------------------");
        session.close();
        sfactory.close();
    }
}
