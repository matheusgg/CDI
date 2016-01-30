package integracao.cdijsf.phaselistener;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import integracao.cdijsf.producer.qualifiers.After;
import integracao.cdijsf.producer.qualifiers.ApplyRequestValues;
import integracao.cdijsf.producer.qualifiers.Before;
import integracao.cdijsf.producer.qualifiers.InvokeApplication;
import integracao.cdijsf.producer.qualifiers.ProcessValidation;
import integracao.cdijsf.producer.qualifiers.RenderResponse;
import integracao.cdijsf.producer.qualifiers.RestoreView;
import integracao.cdijsf.producer.qualifiers.UpdateModelValues;

public class AppPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1210258574381442274L;

	@Inject
	private Event<PhaseEvent> phaseEvent;

	/**
	 * Antes do JSF 2.2, nao era possivel injetar recursos dentro de
	 * conversores, validadores e phase listeners utilizando CDI. Desta forma,
	 * para utilizar as funcionalidades do CDI em ambientes pre JSF 2.2, basta
	 * realizar o look up programatico da instancia de BeanManager. Esta classe
	 * permite utilizar os recursos oferecidos pelo CDI, como por exemplo,
	 * disparo de eventos, localizacao de beans, etc.
	 */
	// private BeanManager beanManager;

	// @PostConstruct
	// protected void init() {
	// try {
	// this.beanManager = InitialContext.doLookup("java:comp/BeanManager");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	@SuppressWarnings("serial")
	@Override
	public void afterPhase(PhaseEvent event) {
		PhaseId phaseId = event.getPhaseId();

		AnnotationLiteral<After> after = new AnnotationLiteral<After>() {};
		AnnotationLiteral<?> phase = null;

		switch (phaseId.getName()) {
			case "RESTORE_VIEW":
				phase = new AnnotationLiteral<RestoreView>() {};
				break;

			case "APPLY_REQUEST_VALUES":
				phase = new AnnotationLiteral<ApplyRequestValues>() {};
				break;

			case "PROCESS_VALIDATIONS":
				phase = new AnnotationLiteral<ProcessValidation>() {};
				break;

			case "UPDATE_MODEL_VALUES":
				phase = new AnnotationLiteral<UpdateModelValues>() {};
				break;

			case "INVOKE_APPLICATION":
				phase = new AnnotationLiteral<InvokeApplication>() {};
				break;

			case "RENDER_RESPONSE":
				phase = new AnnotationLiteral<RenderResponse>() {};
				break;
		}

		this.phaseEvent.select(after, phase).fire(event);
	}

	@SuppressWarnings("serial")
	@Override
	public void beforePhase(PhaseEvent event) {
		PhaseId phaseId = event.getPhaseId();

		AnnotationLiteral<Before> after = new AnnotationLiteral<Before>() {};
		AnnotationLiteral<?> phase = null;

		switch (phaseId.getName()) {
			case "RESTORE_VIEW":
				phase = new AnnotationLiteral<RestoreView>() {};
				break;

			case "APPLY_REQUEST_VALUES":
				phase = new AnnotationLiteral<ApplyRequestValues>() {};
				break;

			case "PROCESS_VALIDATIONS":
				phase = new AnnotationLiteral<ProcessValidation>() {};
				break;

			case "UPDATE_MODEL_VALUES":
				phase = new AnnotationLiteral<UpdateModelValues>() {};
				break;

			case "INVOKE_APPLICATION":
				phase = new AnnotationLiteral<InvokeApplication>() {};
				break;

			case "RENDER_RESPONSE":
				phase = new AnnotationLiteral<RenderResponse>() {};
				break;
		}

		this.phaseEvent.select(after, phase).fire(event);
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
