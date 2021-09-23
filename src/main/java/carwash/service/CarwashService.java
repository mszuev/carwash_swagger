package carwash.service;

import carwash.model.ServiceType;
import java.util.List;

public interface CarwashService {
    List<ServiceType> allServiceType();
    void add(ServiceType object);
    boolean delete(ServiceType object);
    boolean update(ServiceType object);
    ServiceType getById(int id);
}
