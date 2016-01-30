package br.com.main;

/**
 * Para utilizar o CDI em um ambiente Java SE, basta colocar a dependencia do
 * WELD SE no projeto e criar o arquivo beans.xml dentro da pasta META-INF.
 * 
 * <br>
 * Uma limitacao em utilizar o CDI em um ambiente Java SE é que apenas 3 escopos
 * estarao disponiveis: Application, Dependent e Singleton.
 * 
 * @author Matheus
 *
 */
public class CdiMain {

	// public static void main(String[] args) {
	// Weld weld = new Weld();
	// WeldContainer container = weld.initialize();
	//
	// GreetingsBuilder builder =
	// container.select(GreetingsBuilder.class).get();
	// String message = builder.buildGreeting("Matheus");
	// System.out.println(message);
	//
	// container.event().fire(builder);
	// weld.shutdown();
	// }

}
