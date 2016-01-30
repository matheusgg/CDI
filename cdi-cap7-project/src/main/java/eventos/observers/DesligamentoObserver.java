package eventos.observers;

import javax.enterprise.event.Observes;

import eventos.anotacoes.Desligamento;
import eventos.enums.TipoDesligamento;
import model.Funcionario;

public class DesligamentoObserver {

	/**
	 * É possivel ter varios observadores para o mesmo evento. Além disso, é
	 * possivel aplicar qualificadores para restringir os tipos de eventos que
	 * este observer escutara. A anotacao Observes registra este método como um
	 * observador de eventos.
	 * 
	 * @param funcionario
	 */
	public void demiteFuncionario(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario) {
		System.out.println("===============> Funcionário demitido! " + funcionario);
	}

	public void aposentaFuncionario(@Observes @Desligamento(TipoDesligamento.APOSENTADORIA) Funcionario funcionario) {
		System.out.println("===============> Funcionário aposentado! " + funcionario);
	}

}
