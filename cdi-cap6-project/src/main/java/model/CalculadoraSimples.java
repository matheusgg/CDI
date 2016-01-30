package model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

import interceptors.Auditavel;

@RequestScoped
@Auditavel
public class CalculadoraSimples implements Calculadora {

	@Override
	public long sum(long x, long y) {
		return x + y;
	}

	@Override
	public long subtract(long x, long y) {
		return x - y;
	}

	@Override
	public double multiply(double x, double y) {
		return x * y;
	}

	@Override
	public double devide(double x, double y) {
		return x / y;
	}

	@PostConstruct
	protected void init() {
		System.out.println(CalculadoraSimples.class.getName() + " inicializada!");
	}

	@PreDestroy
	protected void destroy() {
		System.out.println(CalculadoraSimples.class.getName() + " prestes a ser destruída!");
	}

}
