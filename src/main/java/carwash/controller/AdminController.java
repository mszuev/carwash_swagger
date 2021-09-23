package carwash.controller;

import carwash.model.Customer;
import carwash.model.ServiceType;
import carwash.service.CarwashService;
import carwash.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "Администратор", description = "Управление услугами")
public class AdminController {

    private CarwashService carwashService;
    private CustomerService customerService;

    @Autowired
    public void setCarwashService(CarwashService carwashService) {
        this.carwashService = carwashService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    @Operation(summary = "Список услуг", description = "Возвращает список услуг")
    public ResponseEntity<List<ServiceType>> allServiceType() {
        final List<ServiceType> serviceTypes = carwashService.allServiceType();
        return serviceTypes != null &&  !serviceTypes.isEmpty()
                ? new ResponseEntity<>(serviceTypes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/calendar")
    @Operation(summary = "Список клиентов", description = "Возвращает список клиентов и время записи")
    public ResponseEntity<List<Customer>> allCustomers() {
        final List<Customer> customerList = customerService.allCustomers();
        return customerList != null &&  !customerList.isEmpty()
                ? new ResponseEntity<>(customerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/add")
    @Operation(summary = "Добавление услуги", description = "Позволяет добавить услугу")
    public ResponseEntity<?> create(@RequestBody ServiceType serviceType) {
        carwashService.add(serviceType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/edit/{id}")
    @Operation(summary = "Услуга по id", description = "Позволяет получить описание услуги")
    public ResponseEntity<ServiceType> edit(@PathVariable(name = "id") int id) {
        final ServiceType serviceType = carwashService.getById(id);

        return serviceType != null
                ? new ResponseEntity<>(serviceType, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/edit/{id}")
    @Operation(summary = "Редактирование услуги", description = "Позволяет редактировать услугу")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ServiceType serviceType) {
        serviceType.setId(id);

        boolean updated = carwashService.update(serviceType);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Удаление услуги", description = "Позволяет удалить услугу")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        ServiceType serviceType = carwashService.getById(id);

        boolean deleted = carwashService.delete(serviceType);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}