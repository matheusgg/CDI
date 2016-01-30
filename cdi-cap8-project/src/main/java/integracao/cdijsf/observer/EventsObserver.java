package integracao.cdijsf.observer;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import integracao.cdijsf.producer.qualifiers.After;
import integracao.cdijsf.producer.qualifiers.Before;
import integracao.cdijsf.producer.qualifiers.RestoreView;

public class EventsObserver {

	public void listenerBeforeRestoreView(@Observes @Before @RestoreView PhaseEvent event) {
		System.out.println("Before " + event.getPhaseId());
	}

	public void listenerAfterRestoreView(@Observes @After @RestoreView PhaseEvent event) {
		System.out.println("After " + event.getPhaseId());
	}

}
