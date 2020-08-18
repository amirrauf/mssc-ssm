package guru.springframework.msscscm.config.actions;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import guru.springframework.msscscm.domain.PaymentEvent;
import guru.springframework.msscscm.domain.PaymentState;

@Component
public class PreAuthDeclinedAction implements Action<PaymentState, PaymentEvent> {
	
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("Sending Notification of Pre Auth DECLINED");
    }

}
