package servlets;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.MessageConstructor;

@WebServlet(value = "/AppServlet", loadOnStartup = 1)
public class AppServlet extends HttpServlet {

	private static final long serialVersionUID = -6406350029561086107L;

	private MessageConstructor messageConstructor;

	@Inject
	public AppServlet(MessageConstructor messageConstructor) {
		this.messageConstructor = messageConstructor;
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@PostConstruct
			void ok() {
		System.out.println("AppServlet.ok()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println(this.messageConstructor.constructMessage());
	}

}
