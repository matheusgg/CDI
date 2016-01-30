package cdi.alternatives;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

/**
 * Beans alternativos no CDI é uma funcionalidade que permite especificar beans
 * elegiveis para injecao, mas que nao serao considerados em um primeiro
 * momento. Ou seja, um bean anotado com Alternative só sera considerado caso
 * seja explicitamente habilitado no arquivo beans.xml ou possua a anotacao
 * Priority, incluida no Java EE 7. Quando um bean alternativo é habilitado, ele
 * possui preferencia sobre todos os beans que podem ser injetados naquele ponto
 * de injecao e que nao sejam alternativos também. Varias classes podem ser
 * anotadas com Alternative, sendo que apenas a habilitada no beans.xml sera
 * utilizada, ou aquela que possuir uma maior prioridade sobre as outras atraves
 * da anotacao Priority, neste caso, o bean alternativo nao precisa ser
 * declarado no arquivo xml.
 * 
 * @author Matheus
 *
 */
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 22)
public class CaculadoraDeSalarioPadrao implements CalculadoraDeSalario {

	@Override
	public double calculaSalario() {
		return 5000.0;
	}

}
