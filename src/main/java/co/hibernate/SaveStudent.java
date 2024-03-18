package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveStudent {


    public static void main(String[] args) {
        SessionFactory sfactory=HibernateUtils.getSessionFactory();

        Session session=sfactory.openSession();
        Transaction tx=session.beginTransaction();

        Student student=new Student();
        student.setStudentId(101);
        student.setStudentName("Shravan Reddy kandakatla");
        student.setStudentEmail("shravan3513@gmail.com");

        session.save(student);
        System.out.println("------------------------------------------------------");

        tx.commit();

        session.close();
        sfactory.close();
    }
}
