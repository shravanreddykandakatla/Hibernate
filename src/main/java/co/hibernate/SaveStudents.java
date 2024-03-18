package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class SaveStudents {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory=HibernateUtils.getSessionFactory();

        Session session=sfactory.openSession();
        Transaction tx=session.beginTransaction();


        String req="Y";


        do{
            System.out.println("enter student name & email: ");
            String name=sc.nextLine();
            String email=sc.nextLine();
            Student student=new Student(name,email);
            //session.save(student);
            Serializable sid= session.save(student); // it will return auto generated student id type serializable object

            System.out.println("student with student id: "+sid+" saved...");

            System.out.print("\n Do you want to insert more employee[y/n]: ");
            req=sc.nextLine();

        }while(req.equalsIgnoreCase("Y"));

        System.out.println("------------------------------------------------------");

        tx.commit();

        session.close();
        sfactory.close();
    }
}
