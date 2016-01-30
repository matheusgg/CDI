package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.typed.CalculadoraDesconto;
import cdi.typed.CalculadoraDesconto16;

@WebServlet(value = "TypedServlet", loadOnStartup = 1)
public class TypedServlet extends HttpServlet {

	private static final long serialVersionUID = -9091269498056371389L;

	@Inject
	private CalculadoraDesconto calculadoraDesconto;

	@Inject
	private CalculadoraDesconto16 calculadoraDesconto16;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("Desconto: R$ " + this.calculadoraDesconto.calculaDesconto());
		writer.println("Desconto 2016: R$ " + this.calculadoraDesconto16.calculaDesconto());
	}

}
