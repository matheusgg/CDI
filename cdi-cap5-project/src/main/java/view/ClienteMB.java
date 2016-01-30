package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Cliente;

/**
 * O escopo Dependent é o escopo padrao do CDI. Neans neste ecopo se comportam
 * da mesma forma dos beans que os injetou. Ou seja, se um bean Dependent é
 * injetado dentro de um bean de Sessao, este bean injetado se comportara da
 * mesma forma do bean de Sessao. Quando beans Dependent sao utilizados em
 * paginas JSF, a cada avaliacao de EL que solicite este bean, uma nova
 * instancia sera criada.
 * 
 * @author Matheus
 *
 */
@Named
// @RequestScoped
// @SessionScoped
// @ApplicationScoped
// @ConversationScoped
@Dependent
public class ClienteMB implements Serializable {

	private static final long serialVersionUID = -1575036985258916744L;

	/**
	 * O escopo de conversacao possui 2 estados: transient e long-running.
	 * Quando um bean de escopo de conversacao esta no estado transient, ele se
	 * comporta como se estivesse no escopo de requisicao, ou seja, a instancia
	 * só estara disponivel durante o processo de requisicao. Porem, quando um
	 * bean de conversacao é promovido para o estado long-running, a instancia é
	 * mantida enquanto a conversacao nao for explicitamente encerrada, isto é,
	 * enquanto o método end() nao for chamado para promover o bean para o
	 * estado transient novamente. Para alterar o estado de um bean de
	 * conversacao, é utilizado o objeto Conversation que deve ser injetado, ele
	 * possui os metodos para iniciar, encerrar e definir o tempo de timeout de
	 * uma conversacao. O objeto Conversation funciona apenas com beans de
	 * escopo de conversacao.
	 */
	@Inject
	private Conversation conversation;

	private List<Cliente> clientes;

	private Cliente cliente;
	
	@PostConstruct
	protected void init() {
		this.clientes = new ArrayList<>();
		this.cliente = new Cliente();
		System.out.println(ClienteMB.class.getSimpleName() + " criado!");
	}

	public void addCliente() {
		this.cliente.setId((long) new Random().nextInt(100));
		this.clientes.add(this.cliente);
		this.cliente = new Cliente();
	}

	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Olá " + this.cliente.getNome()));
	}

	public void iniciaConversacao() {
		if (this.conversation.isTransient()) {
			this.conversation.begin();
		}
	}

	public void terminaConversacao() {
		if (!this.conversation.isTransient()) {
			this.conversation.end();
		}
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes
	 *            the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
