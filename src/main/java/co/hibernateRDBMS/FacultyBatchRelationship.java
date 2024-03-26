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
        faculty.setFacultyId(102);
        faculty.setFacultyName("Sumith");

        Batch batch1=new Batch("Java",faculty);
        Batch batch2=new Batch("Spring",faculty);
        Batch batch3=new Batch("Microservices",faculty);

        Set<Batch> batches= new HashSet<Batch>();
        batches.add(batch1);
        batches.add(batch2);
        batches.add(batch3);

        int size=batches.size();

        System.out.println(size);

        faculty.setBatches(batches);

        session.save(faculty);

        tx.commit();
        session.close();
        sfactory.close();
    }
}
