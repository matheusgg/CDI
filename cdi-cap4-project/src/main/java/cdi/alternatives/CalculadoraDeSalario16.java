package cdi.alternatives;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

/**
 * Quando a anotacao Priority é utilizada com CDI e beans alternativos, o bean
 * que possuir a maior prioridade será considerado.
 * 
 * @author Matheus
 *
 */
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 21)
public class CalculadoraDeSalario16 implements CalculadoraDeSalario {

	@Override
	public double calculaSalario() {
		return 6000.0;
	}

}
