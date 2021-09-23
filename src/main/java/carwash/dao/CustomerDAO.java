package carwash.dao;

import carwash.model.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> allCustomers();
    void add(Customer object);
    void delete(Customer object);
    void edit(Customer object);
    Customer getById(int id);
}

