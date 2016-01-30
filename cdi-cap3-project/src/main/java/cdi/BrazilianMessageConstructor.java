package cdi;

import javax.inject.Inject;

/**
 * As anotacoes do CDI nao tem efeito em membros de uma interface, ou seja, se o
 * metodo constructText() da interface MessageConstructor for anotado com
 * Inject, o CDI nao injetara o objeto no metodo que sobrescreve aquele metodo
 * declarado na interface.
 * 
 * @author Matheus
 *
 */
// @Vetoed
public class BrazilianMessageConstructor implements MessageConstructor {

	@Override
	public String constructMessage() {
		return "Seja Bem-Vindo!";
	}

	/**
	 * O CDI pode realizar a injecao de tres maneiras diferentes: Via atributo
	 * privado, via método inicializador e via construtor. Neste caso, a forma
	 * via método inicializador fui utilizada, ou seja, é possivel criar um
	 * metodo setXXX e informar para o CDI construir o objeto que sera setado em
	 * alguma propriedade, neste caso, na construcao do objeto
	 * BrazilianMessageConstructor, o CDI injetara o objeto
	 * TextConstructor no parametro que o metodo constructText() recebe.
	 * 
	 * @see cdi.MessageConstructor#constructText(cdi.TextConstructor)
	 */
	@Inject
	@Override
	public String constructText(TextConstructor textConstructor) {
		return textConstructor.getText();
	}

}
