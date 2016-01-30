package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Calculadora;
import model.CalculadoraBean;

@WebServlet(value = "AppServlet", loadOnStartup = 1)
public class AppServlet extends HttpServlet {

	private static final long serialVersionUID = -6406350029561086107L;

	@Inject
	private Calculadora calculadora;

	@EJB
	private CalculadoraBean calculadoraBean;

	@Inject
	private HttpServletRequest request;

	@Override
	public void init() throws ServletException {
		this.getClass();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		Number result = null;

		switch (op) {
			case "sum": {
				long x = Long.valueOf(req.getParameter("x"));
				long y = Long.valueOf(req.getParameter("y"));
				result = this.calculadora.sum(x, y);
				break;
			}

			case "sub": {
				long x = Long.valueOf(req.getParameter("x"));
				long y = Long.valueOf(req.getParameter("y"));
				result = this.calculadora.subtract(x, y);
				break;
			}

			case "mul": {
				double x = Double.valueOf(req.getParameter("x"));
				double y = Double.valueOf(req.getParameter("y"));
				result = this.calculadora.multiply(x, y);
				break;
			}

			case "div": {
				double x = Double.valueOf(req.getParameter("x"));
				double y = Double.valueOf(req.getParameter("y"));
				result = this.calculadora.devide(x, y);
				break;
			}
		}

		PrintWriter writer = resp.getWriter();
		writer.println(this.calculadora);
		writer.println("Resultado: " + result);

		writer.println(this.calculadoraBean);
		writer.println(this.calculadoraBean.constructMessage());
		writer.println(this.calculadoraBean.sum(30, 20));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		Long x = (Long) this.request.getAttribute("x;t=java.lang.Long");
		if (x != null) {
			writer.println(x.getClass() + ": " + x);
		}
	}

}
