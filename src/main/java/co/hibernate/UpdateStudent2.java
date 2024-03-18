package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Objects;
import java.util.Scanner;

public class UpdateStudent2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();
        session.beginTransaction();
        System.out.println("enter student ID: ");
        Integer sid=sc.nextInt();
        Student student=session.get(Student.class,sid);
        if(Objects.nonNull(student)){
            System.out.println(student);
            student.setStudentName("Manisha");
        }
        System.out.println(student);
        System.out.println("------------------------------------------------------");
        session.getTransaction().commit();

        session.close();
        sfactory.close();
    }
}
