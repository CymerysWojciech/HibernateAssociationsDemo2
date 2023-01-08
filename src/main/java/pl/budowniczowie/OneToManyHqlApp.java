package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Company;
import pl.budowniczowie.entity.CompanyDetail;
import pl.budowniczowie.entity.Property;

import java.util.List;

public class OneToManyHqlApp {
    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        String getCompany = "select c.name from Property p join p.company c  where p.city='Sevilla'";
        session.beginTransaction();

        Query query = session.createQuery(getCompany);

        List<String> resultList = (List<String>) query.getResultList();

        session.getTransaction().commit();

        for (String result: resultList) {
            System.out.println(result);
        }

        factory.close();
    }
}
