package spi.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

/**
 * O CDI permite a criacao de extensoes portaveis atraves da Interface de
 * Provedor de Servicos (SPI). Para tanto, basta implementar
 * a interface javax.enterprise.inject.spi.Extension e observar o evento
 * desejado para personalizar ou criar alguma configuracao. As extencoes CDI sao
 * carregadas na inicializacao do container por meio do ServiceLoader, desta
 * forma, basta criar um arquivo de texto chamado
 * javax.enterprise.inject.spi.Extension dentro da pasta META-INF/services com
 * os nomes totalmente qualificados das extensoes criadas, ou seja, as classes
 * que implementam Extension.
 * 
 * <br>
 * 
 * O CDI dispara varios evendos na inicializacao do container. Para criar uma
 * configuracao extensivel basta observar o evento desejado do pacote
 * javax.enterprise.inject.spi:
 * <ul>
 * <li>BeforeBeanDiscovery</li>
 * <li>AfterBeanDiscovery</li>
 * <li>ProcessAnnotatedType</li>
 * <li>ProcessBeanAttributes</li>
 * <li>ProcessProducer</li>
 * <li>ProcessObserverMethod</li>
 * <li>ProcessInjectionPoint</li>
 * <li>Etc.</li>
 * </ul>
 * 
 * @author Matheus
 *
 */
public class ConventionOverConfigurationExtension implements Extension {

	/**
	 * Este metodo observador processa eventos do tipo ProcessAnnotatedType e
	 * realiza uma configuracao de acordo com convensao, isto é, todos os beans
	 * que estiverem no pacote view, ganharao o estereotipo
	 * RequestManagedBean, se tornando assim, NamedBeans disponiveis para serem
	 * utilizados pelo JSF nas paginas xhtml.
	 * <hr>
	 * Diferente dos observadores normais, os observadores de extensoes podem
	 * ter apenas um ponto de injecao, e este ponto de injecao pode ser apenas
	 * para injetar o BeanManager.
	 */
	public <T> void defineRequestMB(@Observes ProcessAnnotatedType<T> pat, BeanManager beanManager) {
		AnnotatedType<T> annotatedType = pat.getAnnotatedType();
		Class<T> clazz = annotatedType.getJavaClass();

		if (clazz.getPackage().getName().endsWith("view")) {
			pat.setAnnotatedType(new RequestMBAnnotatedTypeWrapped<>(annotatedType));
		}
	}

}