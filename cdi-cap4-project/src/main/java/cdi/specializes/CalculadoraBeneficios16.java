package cdi.specializes;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.interceptor.Interceptor;

/**
 * A anotacao Specializes indica que este bean é uma especializacao direta de
 * CalculadoraBeneficios15, deste modo, em todos os pontos onde o tipo
 * CalculadoraBeneficios15 seria utilizado, o CDI criara uma instancia de
 * CalculadoraBeneficios16, que é a especifializacao do primeiro bean. Esta
 * anotacao também pode ser utilizada em metodos produtores, neste caso, um
 * metodo produtor tem que ser sobrescrito, onde o segundo metodo sera uma
 * especializacao do primeiro e sempre sera utilizado.
 * 
 * @author Matheus
 *
 */
@Specializes
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class CalculadoraBeneficios16 extends CalculadoraBeneficios15 {

	@Override
	public double calculaValorBeneficio() {
		return 600.0;
	}

}
