package guru.springframework.msscscm.services;

import org.springframework.statemachine.StateMachine;

import guru.springframework.msscscm.domain.Payment;
import guru.springframework.msscscm.domain.PaymentEvent;
import guru.springframework.msscscm.domain.PaymentState;

public interface PaymentService {
    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
