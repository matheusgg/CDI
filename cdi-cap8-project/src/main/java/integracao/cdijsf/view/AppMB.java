package integracao.cdijsf.view;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import integracao.cdijsf.producer.qualifiers.ApplicationMap;
import integracao.cdijsf.producer.qualifiers.RequestMap;
import integracao.cdijsf.producer.qualifiers.RequestParameterMap;
import integracao.cdijsf.producer.qualifiers.SessionMap;
import integracao.cdijsf.producer.qualifiers.ViewMap;

@Named
@RequestScoped
public class AppMB implements Serializable {

	private static final long serialVersionUID = -1878007013145412923L;

	@Inject
	@RequestMap
	private Map<String, Object> requestMap;

	@Inject
	@RequestParameterMap
	private Map<String, String> requestParameterMap;

	@Inject
	@SessionMap
	private Map<String, Object> sessionMap;

	@Inject
	@ViewMap
	private Map<String, Object> viewMap;

	@Inject
	@ApplicationMap
	private Map<String, Object> applicationMap;

	/**
	 * @return the requestMap
	 */
	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	/**
	 * @return the requestParameterMap
	 */
	public Map<String, String> getRequestParameterMap() {
		return requestParameterMap;
	}

	/**
	 * @return the sessionMap
	 */
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	/**
	 * @return the viewMap
	 */
	public Map<String, Object> getViewMap() {
		return viewMap;
	}

	/**
	 * @return the applicationMap
	 */
	public Map<String, Object> getApplicationMap() {
		return applicationMap;
	}

}
