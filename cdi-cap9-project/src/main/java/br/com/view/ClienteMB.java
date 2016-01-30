package br.com.view;

import javax.enterprise.inject.Vetoed;

/**
 * A anotacao Vetoed faz com que o CDI nao processe esse bean, desta forma, ele
 * nao ficara disponivel para injecao de dependencia.
 * 
 * @author Matheus
 *
 */
@Vetoed
public class ClienteMB {

}
