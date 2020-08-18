package guru.springframework.msscscm.services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.msscscm.domain.Payment;
import guru.springframework.msscscm.domain.PaymentEvent;
import guru.springframework.msscscm.domain.PaymentState;
import guru.springframework.msscscm.repository.PaymentRepository;

@SpringBootTest
class PaymentServiceImplTest {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	PaymentService paymentService;
	
	Payment payment;
	
	

	@BeforeEach
	void setUp() throws Exception {
		payment = Payment.builder().amount(new BigDecimal("12.99")).build();
	}

	@Transactional
	@Test
	void testPreAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        System.out.println("Should be NEW");
        System.out.println(savedPayment.getState());

        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getOne(savedPayment.getId());

        System.out.println("Should be PRE_AUTH or PRE_AUTH_ERROR");
        System.out.println(sm.getState().getId());

        System.out.println(preAuthedPayment);
	}

}
