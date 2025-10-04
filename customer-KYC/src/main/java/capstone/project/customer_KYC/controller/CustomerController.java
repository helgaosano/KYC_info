package capstone.project.customer_KYC.controller;

import capstone.project.customer_KYC.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET endpoint to fetch a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        return customerService.getId(id)
                .map(customer -> {
                    logger.info("Fetched customer details: {}", customer); // 👈 Logs the response
                    return ResponseEntity.ok(customer);
                })
                .orElseGet(() -> {
                    logger.warn("Customer with ID {} not found", id); // 👈 Logs missing customer
                    return ResponseEntity.notFound().build();
                });
    }
}

