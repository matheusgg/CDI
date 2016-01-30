package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.CalculadoraDeImpostos;
import cdi.alternatives.CalculadoraDeSalario;
import cdi.qualifiers.CalculadoraVigente;
import cdi.qualifiers.util.Ano;

@WebServlet(value = "CDIServlet", loadOnStartup = 1)
public class CDIServlet extends HttpServlet {

	private static final long serialVersionUID = -6406350029561086107L;

	/**
	 * O CDI é capaz de considerar os valores dos atributos nos qualificadores
	 * para tentar identificar o tipo correto da dependencia que devera ser
	 * injetada.
	 */
	@Inject
	@CalculadoraVigente(Ano.ANO_2015)
	private CalculadoraDeImpostos calculadora;

	@Inject
	private CalculadoraDeSalario calculadoraSalario;

	/**
	 * Caso o nome do bean nao seja especificado na anotacao Named, o CDI
	 * utilizara o nome do atributo para localizar o bean que devera ser
	 * injetado.
	 */
	@Inject
	@Named
	private String config1;

	@Inject
	@Named("config2")
	private int config2;

	@Inject
	@Named
	private String geraConfiguracao3;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("Imposto calculado de " + this.calculadora.ano() + ": R$ " + this.calculadora.calculaImposto());
		writer.println("Salário calculado: R$ " + this.calculadoraSalario.calculaSalario());
		writer.println(this.config1);
		writer.println(this.config2);
		writer.println(this.geraConfiguracao3);
	}

}
