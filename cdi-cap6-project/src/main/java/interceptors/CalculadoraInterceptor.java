package interceptors;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * A partir do CDI 1.1, para habilitar um interceptor basta adicionar a anotacao
 * de prioridade, que além de habilitar, também define a ordem de execucao dos
 * interceptadores. Os interceptors que possuirem a menor prioridade serao
 * invocados primeiro. Caso seja definido o mesmo valor de prioridade ara
 * interceptors diferentes, a ordem de execucao é indefinida.
 * <br >
 * Existem 5 tipos de métodos interceptadores: AroundInvoke, AroundTimeout,
 * AroundConstruct, PostConstruct e PreDestroy.
 * 
 * @author Matheus
 *
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Auditavel
public class CalculadoraInterceptor {

	private Logger logger = Logger.getLogger(CalculadoraInterceptor.class.getName());

	/**
	 * O objeto InvocationContext possui informacoes do ponto de injecao e do
	 * objeto que esta sendo interceptado, além de ser o responsavel pela
	 * invocacao do método alvo.
	 * 
	 * @param context
	 * @return
	 */
	@AroundInvoke
	public Object log(InvocationContext context) {
		Method method = context.getMethod();
		Object target = context.getTarget();
		Object[] params = context.getParameters();

		this.logger.info(String.format("Interceptando a chamada ao método %s da classe %s com %d parâmetros.", method.getName(), target, params.length));

		try {
			return context.proceed();
		} catch (Exception e) {
			this.logger.severe(String.format("Ocorreu o seguinte erro: %s", e.getMessage()));
		}

		return null;
	}

	/**
	 * Os métodos AroundInvoke sao chamados quando um método que deve ser
	 * interceptado é invocado manualmente por um cliente. Já os metodos
	 * AroundTimeout sao utilizados apenas via EJB timer, ou seja, sao invocados
	 * automaticamente quando o container invoca o metodo schedulado.
	 * 
	 * @param context
	 * @return
	 */
	@AroundTimeout
	public Object logTimeout(InvocationContext context) {
		Method method = context.getMethod();
		Object target = context.getTimer();
		Object[] params = context.getParameters();

		this.logger.info(String.format("Interceptando a chamada ao método timeout %s do EJB %s com %d parâmetros.", method.getName(), target, params.length));

		try {
			return context.proceed();
		} catch (Exception e) {
			this.logger.severe(String.format("Ocorreu o seguinte erro: %s", e.getMessage()));
		}

		return null;
	}

	/**
	 * Os métodos AroundConstruct sao chamados antes que o CDI construa o objeto
	 * solicitado, ou seja, antes que o construtor da classe seja invocado.
	 * Deste movo, só é possivel chamar o método getTarget() de
	 * InvocationContext após a invocacao do método proceed().
	 * 
	 * @param context
	 */
	@AroundConstruct
	public void preConstruct(InvocationContext context) {
		try {
			context.proceed();
			this.logger.info(String.format("Interceptando a criação do objeto %s.", context.getTarget()));
		} catch (Exception e) {
			this.logger.severe(String.format("Ocorreu o seguinte erro: %s", e.getMessage()));
		}
	}

	/**
	 * Os métodos interceptores PostConstruct sao chamados assim que o objeto
	 * esta criado e inicializado. Esses metodos interceptores sao chamados
	 * antes dos metodos anotados com PostConstruct dentro da instancia criada,
	 * que por sua vez so serao chamados caso haja a invocacao do método
	 * proceed(). Porem, existe uma restricao na utilizacao de metodos
	 * interceptores do tipo PostConstruct, a anotacao de binding entre o
	 * interceptor e o objeto alvo pode declarar o target apenas como TYPE
	 * (@Target({ ElementType.TYPE})).
	 * 
	 * @param context
	 */
	@PostConstruct
	public void init(InvocationContext context) {
		try {
			Object target = context.getTarget();
			context.proceed();
			this.logger.info(String.format("Interceptando a construção do objeto %s.", target));
		} catch (Exception e) {
			this.logger.severe(String.format("Ocorreu o seguinte erro: %s", e.getMessage()));
		}
	}

	/**
	 * Os métodos interceptores PreDestroy sao chamados assim que o objeto
	 * esta criado e inicializado. Esses metodos interceptores sao chamados
	 * antes dos metodos anotados com PreDestroy dentro da instancia criada,
	 * que por sua vez so serao chamados caso haja a invocacao do método
	 * proceed(). Porem, existe uma restricao na utilizacao de metodos
	 * interceptores do tipo PostConstruct, a anotacao de binding entre o
	 * interceptor e o objeto alvo pode declarar o target apenas como TYPE
	 * (@Target({ ElementType.TYPE})).
	 * 
	 * @param context
	 */
	@PreDestroy
	public void destroy(InvocationContext context) {
		try {
			Object target = context.getTarget();
			context.proceed();
			this.logger.info(String.format("Interceptando a destruição do objeto %s.", target));
		} catch (Exception e) {
			this.logger.severe(String.format("Ocorreu o seguinte erro: %s", e.getMessage()));
		}
	}
}
