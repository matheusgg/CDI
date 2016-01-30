package br.com.cdi.test;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.cdi.GreetingsBuilder;

/**
 * O Arquillian possui 3 tipos de adaptadores: Embedded, Managed e Remote. No
 * tipo Embedded, o Arquillian cuida de todas as etapas referente ao servidor de
 * aplicacao, ou seja, ele realiza o download e inicia o servidor, faz o deploy
 * da aplicacao, executa os testes e encerra o servidor. Utilizando o tipo
 * Managed, o Arquillian utiliza uma instalacao de servidor ja pronta, desta
 * forma, ele apenas inicia o servidor especificado no arquivo arquillian.xml,
 * faz o deploy da aplicacao, executa os testes e encerra o servidor. Por fim, o
 * adaptador Remote é semelhante ao adaptador Managed, a unica diferenca é que o
 * Arquillian utiliza uma instacao de em servidor ja existente e em execucao.
 * 
 * <hr>
 * Para o Arquillian manipular o ciclo de vida dos testes integrados, iniciar e
 * encerrar os servidores de aplicacao, é necessário informar o runner dele na
 * anotacao RunWith do JUnit.
 * 
 * @author Matheus
 *
 */
@RunWith(Arquillian.class)
public class GreetingsTest {

	@Inject
	private GreetingsBuilder builder;

	/**
	 * O método estatico anotado com Deployment é utilizado pelo Arquillain para
	 * montar o pacote que sera utilizado no teste integrado.
	 * 
	 * @return
	 */
	@Deployment
	public static WebArchive createDeployment() {
		String webInfPath = "/Users/Matheus/Documents/workspace/cdi-cap10-project/src/main/webapp/WEB-INF/";
		return ShrinkWrap.create(WebArchive.class).addPackages(true, "br.com").addAsWebInfResource(new File(webInfPath + "beans.xml")).addAsWebInfResource(
				new File(webInfPath + "web.xml"));
	}

	@Test
	public void testGreetingsWithName() {
		Assert.assertEquals("Seja bem vindo Matheus!", this.builder.buildGreeting("Matheus"));
	}

	@Test
	public void testGreetingsWithoutName() {
		Assert.assertEquals("Seja bem vindo usuário!", this.builder.buildGreeting(null));
	}

}
