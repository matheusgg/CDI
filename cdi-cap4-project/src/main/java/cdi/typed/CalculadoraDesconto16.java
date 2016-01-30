package cdi.typed;

import javax.enterprise.inject.Typed;

/**
 * A anotacao Typed restringe os tipos deste bean, ou seja, o bean
 * CalculadoraDesconto16 pode ser utilizado como candidato de injecao apenas
 * para os tipos CalculadoraDesconto16 e Object (isto é, os tipos especificados
 * na anotacao Typed, lembrando que o tipo Object é utilizado por padrao).
 * 
 * @author Matheus
 *
 */
@Typed({ CalculadoraDesconto16.class })
public class CalculadoraDesconto16 extends CalculadoraDesconto15 {

	@Override
	public double calculaDesconto() {
		return super.calculaDesconto() + 50.0;
	}

}
