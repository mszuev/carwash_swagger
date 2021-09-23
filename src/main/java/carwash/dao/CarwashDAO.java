package carwash.dao;

import carwash.model.ServiceType;
import java.util.List;

public interface CarwashDAO {
    List<ServiceType> allServiceType();
    void add(ServiceType object);
    boolean delete(ServiceType object);
    boolean update(ServiceType object);
    ServiceType getById(int id);
}
