package capstone.project.customer_KYC;

import capstone.project.customer_KYC.model.Customer;
import capstone.project.customer_KYC.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getId(Long id) {
        return customerRepository.findById(id);
    }
}
