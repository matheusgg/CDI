package cdi.qualifiers;

import javax.enterprise.util.AnnotationLiteral;

import cdi.qualifiers.util.Ano;

/**
 * A classe AnnotationLiteral permite simular uma anotacao de forma
 * programatica, deste modo, é possível instanciar essa
 * CalculadoraVigenteLiteral para ser utilizada quando uma anotacao do tipo
 * CalculadoraVigente for requerida. É importante ressaltar que apesar desta
 * classe simular uma anotacao, ela continua nao sendo uma anotacao. Outro ponto
 * importante é que essa classe só se faz necessária quando é preciso simular
 * uma anotacao que possua atributos, caso a anotacao nao tenha atributos basta
 * instanciar a classe AnnotationLiteral onde a anotacao é utilizada.
 * 
 * @author Matheus
 *
 */
public class CalculadoraVigente15Literal extends AnnotationLiteral<CalculadoraVigente>implements CalculadoraVigente {

	private static final long serialVersionUID = -7683360031237376274L;

	private Ano ano;
	private boolean calculadoraNova;

	public CalculadoraVigente15Literal() {
		this.ano = Ano.ANO_2015;
		this.calculadoraNova = true;
	}

	@Override
	public Ano value() {
		return this.ano;
	}

	@Override
	public boolean calculadoraNova() {
		return this.calculadoraNova;
	}

}
