package br.com.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cdi.GreetingsBuilder;

@WebServlet(value = "/AppServlet", loadOnStartup = 1)
public class AppServlet extends HttpServlet {

	private static final long serialVersionUID = -6652040821641878543L;

	@Inject
	private GreetingsBuilder greetingsBuilder;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String greeting = this.greetingsBuilder.buildGreeting(usuario);
		resp.getWriter().println(greeting);
	}

}
