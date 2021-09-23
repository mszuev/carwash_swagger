package carwash.dao;

import carwash.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> allCustomers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer").list();
    }

    @Override
    public void add(Customer object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
    }

    @Override
    public void delete(Customer object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

    @Override
    public void edit(Customer object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public Customer getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }
}
