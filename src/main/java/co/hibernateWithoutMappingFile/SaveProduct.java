package co.hibernateWithoutMappingFile;



import co.hibernateWithoutMappingFile.entity.Product;
import co.hibernateWithoutMappingFile.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveProduct {


    public static void main(String[] args) {
        SessionFactory sfactory= HibernateUtils.getSessionFactory();

        Session session=sfactory.openSession();
        Transaction tx=session.beginTransaction();

        Product product=new Product();
        product.setProductId(102);
        product.setProductName("Car");
        product.setProductPrice(65000.2F);

        session.save(product);
        System.out.println("------------------------------------------------------");

        tx.commit();
        System.out.println("Product info is Saved!!!"+product.toString());
        session.close();
        sfactory.close();
    }
}
