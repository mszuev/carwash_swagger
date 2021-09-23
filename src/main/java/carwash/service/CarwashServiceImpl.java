package carwash.service;

import carwash.dao.CarwashDAO;
import carwash.model.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CarwashServiceImpl implements CarwashService {

    private CarwashDAO carwashDAO;

    @Autowired
    public void setCarwashServiceImpl(CarwashDAO carwashDAO) {
        this.carwashDAO = carwashDAO;
    }

    @Transactional
    @Override
    public List<ServiceType> allServiceType() {
        return carwashDAO.allServiceType();
    }

    @Transactional
    @Override
    public void add(ServiceType object) {
        carwashDAO.add(object);
    }

    @Transactional
    @Override
    public boolean delete(ServiceType object) {
        return carwashDAO.delete(object);
    }

    @Transactional
    @Override
    public boolean update(ServiceType object) {
        return carwashDAO.update(object);
    }

    @Transactional
    @Override
    public ServiceType getById(int id) {
        return carwashDAO.getById(id);
    }
}
