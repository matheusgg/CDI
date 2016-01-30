package eventos.observers;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import model.Funcionario;

@Stateless
public class FuncionarioBean {

	/**
	 * Como o CDI faz parte da especificacao Java EE, ele se integra com as
	 * demais especificacoes, deste modo, para se implementar observadores de
	 * eventos assincronos, é necessário utilizar a funcionalidade assincrona ja
	 * presente nos EJBs, ou seja, basta anotar um metodo observador de um EJB
	 * com Asynchronous e o CDI disparara eventos assincronos para este metodo.
	 * 
	 * @param funcionario
	 */
	@Asynchronous
	public void observaOperacaoFuncionario(@Observes Funcionario funcionario) {
		System.out.println("---------------------------> " + funcionario);
	}

}
