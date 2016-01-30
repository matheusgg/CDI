package eventos.anotacoes;

import javax.enterprise.util.AnnotationLiteral;

import eventos.enums.TipoDesligamento;

/**
 * Classe responsavel por simular o qualificador de Desligamento de acordo com o
 * tipo de evento (DEMISSAO ou APOSENTADORIA) para selecionar o observador
 * correto no disparo do evento de desligamento.
 * 
 * @author Matheus
 *
 */
public class DesligamentoAnnotationLiteral extends AnnotationLiteral<Desligamento>implements Desligamento {

	private static final long serialVersionUID = 2467886920067850294L;

	private TipoDesligamento tipoDesligamento;

	/**
	 * @param tipoDesligamento
	 */
	public DesligamentoAnnotationLiteral(TipoDesligamento tipoDesligamento) {
		this.tipoDesligamento = tipoDesligamento;
	}

	@Override
	public TipoDesligamento value() {
		return this.tipoDesligamento;
	}

}
