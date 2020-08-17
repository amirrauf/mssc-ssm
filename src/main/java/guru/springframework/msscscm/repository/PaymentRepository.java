package guru.springframework.msscscm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.msscscm.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
