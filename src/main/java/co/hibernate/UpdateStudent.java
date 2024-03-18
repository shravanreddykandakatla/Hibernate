package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;

public class UpdateStudent {


    public static void main(String[] args) {
        SessionFactory sfactory=HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();
        session.beginTransaction();

        Student student=new Student(102,"Shreya Reddy Kandhakattla","shreya@gmail.com");
        session.update(student);

        session.getTransaction().commit();

        session.close();
        sfactory.close();
    }
}
