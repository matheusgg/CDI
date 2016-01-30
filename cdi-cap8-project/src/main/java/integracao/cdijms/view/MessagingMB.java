package integracao.cdijms.view;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Named
@ApplicationScoped
public class MessagingMB implements Serializable {

	private static final long serialVersionUID = 1413308787543279864L;

	private String message;

	@Inject
	@JMSConnectionFactory("jms/DefaultJMSConnectionFactory")
	private JMSContext jmsContext;

	@Resource(mappedName = "jms/queue/CustomDefaultQueue")
	private Queue queue;

	@Inject
	private FacesContext facesContext;

	public void sendMessage() {
		this.jmsContext.createProducer().send(this.queue, this.message);
		this.message = null;
		this.facesContext.addMessage(null, new FacesMessage("Mensagem enviada com sucesso!"));
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
