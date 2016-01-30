package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.qualifiers.CalculadoraVigente;
import cdi.specializes.CalculadoraBeneficios;

@WebServlet(value = "SpecializesServlet", loadOnStartup = 1)
public class SpecializesServlet extends HttpServlet {

	private static final long serialVersionUID = -3635594279848032581L;

	@Inject
	@CalculadoraVigente
	private CalculadoraBeneficios calculadoraBeneficios;

	@Inject
	@Named("nomeBeneficio")
	private String nomeBeneficio;

	@Inject
	private Event<CalculadoraBeneficios> event;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Benefícios calculados: R$ " + this.calculadoraBeneficios.calculaValorBeneficio());
		writer.println("Nome do benefício: " + this.nomeBeneficio);

		this.event.fire(this.calculadoraBeneficios);
	}

}
