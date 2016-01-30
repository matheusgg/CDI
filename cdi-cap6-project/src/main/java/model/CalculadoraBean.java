package model;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

import interceptors.Auditavel;

@Stateless
@Auditavel
public class CalculadoraBean {

	public long sum(long x, long y) {
		return x + y;
	}

	/**
	 * Esse método será interceptado por CalculadoraInterceptor.logTimeout(),
	 * pois este EJB esta marcado para ser interceptado pela classe
	 * CalculadoraInterceptor. Toda vez que o container invocar esse método
	 * automaticamente, o interceptor chamara o método logTimeout() que está
	 * anotado com AroundTimeout.
	 */
	@Schedule(hour = "*", minute = "*", second = "*/30", persistent = false)
	public String constructMessage() {
		System.out.println("Mensagem de Teste");
		return "Mensagem de Teste";
	}

}
