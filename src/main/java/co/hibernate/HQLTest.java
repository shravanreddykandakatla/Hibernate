package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HQLTest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();

        String hql="from co.hibernate.entity.Student";
        Query<Student> q=session.createQuery(hql,Student.class);
        List<Student> students=q.getResultList();
        printStudents(students);

        session.close();
        sfactory.close();
    }

    private static void printStudents(List<Student> students) {
        for(Student student:students){
            System.out.println(student);
            try {
                Thread.sleep(100);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
