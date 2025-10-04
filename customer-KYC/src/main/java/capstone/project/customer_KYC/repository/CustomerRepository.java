package capstone.project.customer_KYC.repository;

import capstone.project.customer_KYC.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
