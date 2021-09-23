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
@RequestMapping("/user")
@Tag(name = "Клиенты", description = "Список услуг и запись")
public class CustomerController {
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

    @PostMapping(value = "/signup/{id}")
    @Operation(summary = "Запись клиента", description = "Позволяет записать клиента на услугу")
    public ResponseEntity<?> signUp(@PathVariable(name = "id") int id, @RequestBody Customer customer) {
        customer.setServiceName(carwashService.getById(id).getServiceName());
        customerService.add(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
