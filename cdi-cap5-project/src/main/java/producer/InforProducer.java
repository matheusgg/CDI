package producer;

import java.util.Random;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;

import model.Cliente;

public class InforProducer {

	/**
	 * É possivel aplicar a anotacao Produces em atributos, deste modo, o valor
	 * deste atributo pode ser injetados em outros pontos do sistema.
	 */
	@Produces
	@Named("mensagem")
	private String mensagem = "Mensagem Global";

	/**
	 * O CDI é capaz de injetar beans nos parametros dos métodos produtores
	 * automaticamente.
	 * 
	 * @param injectionPoint
	 * @param cliente
	 * @return
	 */
	@Produces
	@Named("info")
	public String produceInfo(InjectionPoint injectionPoint, @Named("usuarioLogado") Cliente cliente) {
		return injectionPoint.getMember().getDeclaringClass().getName();
	}

	@Produces
	@Named("usuarioLogado")
	public Cliente getUsuarioLogado() {
		Cliente cliente = new Cliente();
		cliente.setId((long) new Random().nextInt(100));
		cliente.setNome("Usuario Logado");
		return cliente;
	}

	/**
	 * Quando o método produtor é utilizado, significa que um objeto foi criado
	 * e adicionado ao contexto do CDI manualmente, deste modo, o descarte deste
	 * objeto tambem ter que ser feito de forma manual, para isso, o CDI
	 * disponibiliza a anotacao Disposes, que deve ser utilizada para anotar um
	 * parametro de um metodo que realizara as acoes de descarte da instancia
	 * criada pelo metodo produtor. Apenas um dos parametros do metodo pode ser
	 * anotado com Disposes, e caso o CDI encontre mais do que um metodo Dispoes
	 * elegivel para o mesmo bean, uma excecao sera lancada. Todos os demais
	 * parametros do metodo que nao sao anotados com Disposes se tornam pontos
	 * de injecao, assim como nos metodos produtores.
	 * 
	 * @param usuarioLogado
	 * @param info
	 */
	public void destroyUsuarioLogado(@Disposes @Named("usuarioLogado") Cliente usuarioLogado, @Named("info") String info) {
		System.out.println(usuarioLogado.getNome());
		System.out.println(info);
	}

}
