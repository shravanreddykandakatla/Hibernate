package co.hibernate;

import co.hibernate.entity.Student;
import co.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLTest1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();

//        String hql="from co.hibernate.entity.Student where studentName like '%K%'";
//        String hql="from co.hibernate.entity.Student where studentId in (101,102)";
        String hql="from co.hibernate.entity.Student where studentId between ?0 and ?1";
        Query<Student> q=session.createQuery(hql,Student.class);
        q.setParameter(0,103);
        q.setParameter(1,104);
        List<Student> students=q.getResultList();
        printStudents(students);

        //performing DML operation using HQL
        hql="update co.hibernate.entity.Student set studentName='K Shravan Reddy' where studentId=101";
        Query<Student> updateQuery=session.createQuery(hql);
        session.beginTransaction();
        int rowsUpdated=updateQuery.executeUpdate();
        System.out.println("Student Updated= "+rowsUpdated);
        session.getTransaction().commit();
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
