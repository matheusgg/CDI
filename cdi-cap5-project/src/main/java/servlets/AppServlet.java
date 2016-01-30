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

@WebServlet(value = "AppServlet", loadOnStartup = 1)
public class AppServlet extends HttpServlet {

	private static final long serialVersionUID = -6406350029561086107L;

	@Inject
	@Named("info")
	private String servletInfo;

	@Inject
	@Named("mensagem")
	private String mensagem;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println(this.servletInfo);
		writer.println(this.mensagem);
	}

}
