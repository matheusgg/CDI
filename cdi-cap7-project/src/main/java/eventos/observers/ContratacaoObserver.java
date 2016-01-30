package eventos.observers;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;

import eventos.anotacoes.Contratacao;
import model.Funcionario;

public class ContratacaoObserver {

	/**
	 * Cada metodo observador so pode ter apenas um parametro anotado com
	 * Observes, os demais serao pontos de injecao, assim como, nos metodos
	 * produtores.
	 * <br>
	 * É possivel obter meta-informacoes sobre o ponto de injecao do evento, o
	 * tipo de evento disparado e os qualificadores atraves da injecao
	 * da instancia de EventMetadata. Esse objeto nao pode ser injetado em
	 * pontos de injecao dentro do observador, apenas como parametro
	 * do metodo.
	 * 
	 * @param funcionario
	 */
	public void contrataFuncionario(@Observes @Contratacao Funcionario funcionario, EventMetadata eventMetadata) {
		System.out.println("==============================================================================================================");
		System.out.println("===============> Novo funcionário contratado! " + funcionario);
		System.out.println(eventMetadata.getInjectionPoint());
		System.out.println(eventMetadata.getType());
		System.out.println(eventMetadata.getQualifiers());
		System.out.println("==============================================================================================================");
	}

}
