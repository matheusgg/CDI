package decorators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Decorated;
import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Com o CDI é possivel implementar o padrao de projeto Decorator. Desta forma,
 * para decorar um bean é necessário que o decorator seja do mesmo tipo deste
 * bean (ou estenda uma superclasse deste bean) e possua um ponto de injecao de
 * delegacao, ou seja, um ponto de injecao com o bean que será decorado. Para
 * habilitar um decorator basta anota-lo com Priority (CDI 1.1) ou declara-lo no
 * arquivo beans.xml. Um decorator pode ter apenas um delegate, porem pode
 * possuir varios pontos de injecao comuns. Os decorators com prioridades
 * menores sao chamados primeiro, além disso, os decorators sao invocados
 * sempre depois dos interceptors e antes dos decorators ativados via XML.
 * 
 * @author Matheus
 *
 */
@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class HttpServletRequestDecorator implements ServletRequest, Serializable {

	private static final long serialVersionUID = -2261778413426409055L;

	/**
	 * Ponto de injecao com o bean que sera decorado.
	 */
	@Inject
	@Delegate
	private HttpServletRequest delegate;

	/**
	 * A partir do CDI 1.1, é possivel obter meta-informacoes dos beans
	 * decorados dentro de um decorator atraves da injecao do objeto Bean. Dessa
	 * forma, é possivel recuperar o nome do bean, classe, qualificadores,
	 * pontos de injecao, etc.
	 */
	@Inject
	@Decorated
	private Bean<HttpServletRequest> httpServletRequestBean;

	@SuppressWarnings("unchecked")
	@Override
	public Object getAttribute(String name) {
		System.out.println(this.httpServletRequestBean.getName());
		System.out.println(this.httpServletRequestBean.getBeanClass());

		String[] paramNameType = name.split(";t=");
		Object paramValue = this.delegate.getAttribute(paramNameType[0]);

		if (paramValue == null) {
			paramValue = this.delegate.getParameter(paramNameType[0]);
		}

		try {
			Class<? extends Number> clazz = (Class<? extends Number>) Class.forName(paramNameType[1]);
			Constructor<? extends Number> constructor = clazz.getConstructor(String.class);
			return constructor.newInstance(paramValue);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return paramValue;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return this.delegate.getAttributeNames();
	}

	@Override
	public String getCharacterEncoding() {
		return this.delegate.getCharacterEncoding();
	}

	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		this.delegate.setCharacterEncoding(env);
	}

	@Override
	public int getContentLength() {
		return this.delegate.getContentLength();
	}

	@Override
	public long getContentLengthLong() {
		return this.delegate.getContentLengthLong();
	}

	@Override
	public String getContentType() {
		return this.delegate.getContentType();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return this.delegate.getInputStream();
	}

	@Override
	public String getParameter(String name) {
		return this.delegate.getParameter(name);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return this.delegate.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		return this.delegate.getParameterValues(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return this.delegate.getParameterMap();
	}

	@Override
	public String getProtocol() {
		return this.delegate.getProtocol();
	}

	@Override
	public String getScheme() {
		return this.delegate.getScheme();
	}

	@Override
	public String getServerName() {
		return this.delegate.getServerName();
	}

	@Override
	public int getServerPort() {
		return this.delegate.getServerPort();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return this.delegate.getReader();
	}

	@Override
	public String getRemoteAddr() {
		return this.delegate.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return this.delegate.getRemoteHost();
	}

	@Override
	public void setAttribute(String name, Object o) {
		this.delegate.setAttribute(name, o);
	}

	@Override
	public void removeAttribute(String name) {
		this.delegate.removeAttribute(name);
	}

	@Override
	public Locale getLocale() {
		return this.delegate.getLocale();
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return this.delegate.getLocales();
	}

	@Override
	public boolean isSecure() {
		return this.delegate.isSecure();
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return this.delegate.getRequestDispatcher(path);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getRealPath(String path) {
		return this.delegate.getRealPath(path);
	}

	@Override
	public int getRemotePort() {
		return this.delegate.getRemotePort();
	}

	@Override
	public String getLocalName() {
		return this.delegate.getLocalName();
	}

	@Override
	public String getLocalAddr() {
		return this.delegate.getLocalAddr();
	}

	@Override
	public int getLocalPort() {
		return this.delegate.getLocalPort();
	}

	@Override
	public ServletContext getServletContext() {
		return this.delegate.getServletContext();
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		return this.delegate.startAsync();
	}

	@Override
	public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
		return this.delegate.startAsync(servletRequest, servletResponse);
	}

	@Override
	public boolean isAsyncStarted() {
		return this.delegate.isAsyncStarted();
	}

	@Override
	public boolean isAsyncSupported() {
		return this.delegate.isAsyncSupported();
	}

	@Override
	public AsyncContext getAsyncContext() {
		return this.delegate.getAsyncContext();
	}

	@Override
	public DispatcherType getDispatcherType() {
		return this.delegate.getDispatcherType();
	}

}
