package br.com.main;

/**
 * O WELD disponibiliza uma classe Main para inicializar o container CDI:
 * org.jboss.weld.environment.se.StartMain. Quando o WELD inicializa o
 * container, ele dispara o evento ContainerInitialized, que pode ser observado
 * por outras classes para executar uma determinada logica.
 * 
 * @author Matheus
 *
 */
public class CdiInitializer {

	// @Inject
	// private GreetingsBuilder builder;

	/**
	 * Método observador de eventos ContainerInitialized. É possivel recuperar
	 * os parametros passados para a classe
	 * org.jboss.weld.environment.se.StartMain utilizando a anotacao Parameters
	 * do WELD.
	 * 
	 * @param containerInitialized
	 * @param parameters
	 */
	// public void init(@Observes ContainerInitialized containerInitialized,
	// @Parameters List<String> parameters) {
	// System.out.println(this.builder.buildGreeting("Matheus"));
	// }

}
