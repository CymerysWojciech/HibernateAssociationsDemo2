package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Company;
import pl.budowniczowie.entity.CompanyDetail;
import pl.budowniczowie.entity.Property;

public class OneToManySaveApp {

    public static void main(String[] args){
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        String getCompany = "select c from Company c join c.properties where c.name='Strefakursow'";
        session.beginTransaction();

        Query query = session.createQuery(getCompany);

        Company company = (Company) query.getSingleResult();
//        Property property0 = new Property("Warszawa", 40);
//        Property property1 = new Property("Gdynia", 70);
//
//        company.addProperty(property0);
//        company.addProperty(property1);

//        session.persist(company);
        System.out.println(company);
        for (Property property: company.getProperties()){
            System.out.println(property);
        }
        session.getTransaction().commit();


        factory.close();
    }

}
