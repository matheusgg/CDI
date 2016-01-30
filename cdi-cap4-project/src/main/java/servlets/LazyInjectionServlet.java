package servlets;

import java.io.IOException;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.CalculadoraDeImpostos;
import cdi.CalculadoraDeImpostos14;
import cdi.qualifiers.CalculadoraVigente15Literal;
import cdi.typed.CalculadoraDesconto;
import cdi.typed.CalculadoraDesconto16;

@WebServlet(value = "LazyInjectionServlet", loadOnStartup = 1)
public class LazyInjectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1628381888070848564L;

	/**
	 * O CDI permite realizar a resolucao de dependencias de maneira
	 * tardia (lazy). Para isso, basta injetar um objeto do tipo Instance
	 * especificando o tipo que deseja ser procurado. Deste modo, quando for
	 * necessaria a utilizacao dessa instancia, basta chamar o método get() da
	 * classe Instance que o CDI criara ou recuperara um bean do contexto. Assim
	 * como ocorre na resolucao normal, é possível especificar qualificadores. O
	 * objeto Instance injetado representa apenas um link para os tipos que
	 * podem ser instanciados. O CDI criara os objetos apenas quando forem
	 * explicitamente solicitados.
	 */
	@Inject
	// @CalculadoraVigente(value = Ano.ANO_2015)
	@Any
	private Instance<CalculadoraDeImpostos> calculadoraImpostosInstance;

	@Inject
	private Instance<CalculadoraDesconto> calculadoraDescontoInstance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Com a resolucao de dependencias lazy, é possivel filtrar os tipos
		 * que deverao ser criados e recuperados do container CDI atraves da
		 * classe ou dos qualificadores.
		 */
		CalculadoraDeImpostos calculadora14 = this.calculadoraImpostosInstance.select(CalculadoraDeImpostos14.class).get();
		resp.getWriter().println("Impostos 2014: R$ " + calculadora14.calculaImposto());

		/*
		 * Utilizando uma classe literal que simula a
		 * anotacao @CalculadoraVigente(value = Ano.ANO_2015, calculadoraNova =
		 * true).
		 */
		CalculadoraDeImpostos calculadora15 = this.calculadoraImpostosInstance.select(new CalculadoraVigente15Literal()).get(); // Ou
		// CalculadoraVigente calculadoraVigente =
		// CalculadoraDeImpostos15.class.getAnnotation(CalculadoraVigente.class);
		// CalculadoraDeImpostos calculadora15 =
		// this.calculadoraImpostosInstance.select(calculadoraVigente).get();
		resp.getWriter().println("Impostos 2015: R$ " + calculadora15.calculaImposto());

		CalculadoraDesconto calculadoraDesconto = this.calculadoraDescontoInstance.select(CalculadoraDesconto16.class).get();
		resp.getWriter().println("Descontos: R$ " + calculadoraDesconto.calculaDesconto());
	}

}
