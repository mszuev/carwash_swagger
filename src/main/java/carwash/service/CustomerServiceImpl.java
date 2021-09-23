package carwash.service;

import carwash.dao.CustomerDAO;
import carwash.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    @Override
    public List<Customer> allCustomers() {
        return customerDAO.allCustomers();
    }

    @Transactional
    @Override
    public void add(Customer object) {
        customerDAO.add(object);
    }

    @Transactional
    @Override
    public void delete(Customer object) {
        customerDAO.delete(object);
    }

    @Transactional
    @Override
    public void edit(Customer object) {
        customerDAO.edit(object);
    }

    @Transactional
    @Override
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }
}
