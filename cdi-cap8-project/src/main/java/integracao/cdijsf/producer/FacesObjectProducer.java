package integracao.cdijsf.producer;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import integracao.cdijsf.producer.qualifiers.ApplicationMap;
import integracao.cdijsf.producer.qualifiers.RequestMap;
import integracao.cdijsf.producer.qualifiers.RequestParameterMap;
import integracao.cdijsf.producer.qualifiers.SessionMap;
import integracao.cdijsf.producer.qualifiers.ViewMap;

public class FacesObjectProducer {

	@Produces
	@RequestScoped
	private FacesContext facesContext = FacesContext.getCurrentInstance();

	@Produces
	@RequestScoped
	private ExternalContext externalContext = this.facesContext.getExternalContext();

	@Produces
	@ApplicationMap
	public Map<String, Object> getApplicationMap(ExternalContext externalContext) {
		return externalContext.getApplicationMap();
	}

	@Produces
	@RequestMap
	public Map<String, Object> getRequestMap(ExternalContext externalContext) {
		return externalContext.getRequestMap();
	}

	@Produces
	@RequestParameterMap
	public Map<String, String> getRequestParameterMap(ExternalContext externalContext) {
		return externalContext.getRequestParameterMap();
	}

	@Produces
	@SessionMap
	public Map<String, Object> getSessionMap(ExternalContext externalContext) {
		return externalContext.getSessionMap();
	}

	@Produces
	@ViewMap
	public Map<String, Object> getApplicationMap(FacesContext facesContext) {
		return facesContext.getViewRoot().getViewMap();
	}

}
