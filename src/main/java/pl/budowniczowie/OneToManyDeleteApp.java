package pl.budowniczowie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.budowniczowie.entity.Company;
import pl.budowniczowie.entity.CompanyDetail;
import pl.budowniczowie.entity.Property;

public class OneToManyDeleteApp {
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

//        Company company = (Company) query.getSingleResult();
//
//        for (Property property: company.getProperties()){
//            if ("Gdynia".equals(property.getCity())){
//                session.remove(property);
//            }
//        }

        Property property = session.get(Property.class, 1);
        session.remove(property);
        session.getTransaction().commit();

        System.out.println(property);


        factory.close();
    }
}
