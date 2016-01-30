package br.com.view;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.model.Cliente;

public class AppMB {

	@Inject
	private Event<Cliente> clienteEvent;

	/**
	 * Recuperando uma referencia atraves do BeanManager
	 * 
	 * @param beanManager
	 */
	@Inject
	@PostConstruct
	protected void init(BeanManager beanManager) {
		// Set<Bean<?>> beans = beanManager.getBeans(AppMB.class);
		// Bean<? extends Object> resolvedBean = beanManager.resolve(beans);
		// CreationalContext<? extends Object> creationalContext =
		// beanManager.createCreationalContext(resolvedBean);
		// AppMB appMB = (AppMB) beanManager.getReference(resolvedBean,
		// AppMB.class, creationalContext);
		// System.out.println(appMB);
	}

	public void triggerEvent() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Matheus");

		this.clienteEvent.fire(cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento disparado!"));
	}

}
