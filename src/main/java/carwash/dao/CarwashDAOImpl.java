package carwash.dao;

import carwash.model.ServiceType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarwashDAOImpl implements CarwashDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ServiceType> allServiceType() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ServiceType").list();
    }

    @Override
    public void add(ServiceType object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
    }

    @Override
    public boolean delete(ServiceType object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
        return true;
    }

    @Override
    public boolean update(ServiceType object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
        return true;
    }

    @Override
    public ServiceType getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ServiceType.class, id);
    }
}