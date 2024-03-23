package co.hibernateRDBMS;

import co.hibernateRDBMS.entity.Batch;
import co.hibernateRDBMS.entity.Faculty;
import co.hibernateRDBMS.utils.HibernateUtils;
import org.hibernate.BaseSessionEventListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class FacultyBatchRelationship {
    public static void main(String[] args) {
        SessionFactory sfactory= HibernateUtils.getSessionFactory();
        Session session=sfactory.openSession();
        Transaction tx=session.beginTransaction();

        Faculty faculty=new Faculty();
        faculty.setFacultyId(101);
        faculty.setFacultyName("Shravan");

        Batch batch1=new Batch("Java Certification",faculty);
        Batch batch2=new Batch("Spring Certification",faculty);
        Batch batch3=new Batch("Microservices Certification",faculty);

        Set<Batch> batches= new HashSet<Batch>();
        batches.add(batch1);
        batches.add(batch2);
        batches.add(batch3);

        System.out.println(batches);

        faculty.setBatches(batches);

        session.save(faculty);

        tx.commit();
        session.close();
        sfactory.close();
    }
}
