package cdi;

import javax.enterprise.inject.Vetoed;

/**
 * A anotacao Vetoed informa para o CDI desconsiderar este tipo na resolucao de
 * denpendencias. Caso ela nao seja aplicada, uma excecao sera lancada, pois
 * existirao mais do que um tipo elegivel para ser injetado em um ponto de
 * injecao.
 * 
 * @author Matheus
 *
 */
@Vetoed
public class AmericanMessageConstructor implements MessageConstructor {

	@Override
	public String constructMessage() {
		return "Welcome!";
	}

	@Override
	public String constructText(TextConstructor textConstructor) {
		return textConstructor.getText();
	}

}
