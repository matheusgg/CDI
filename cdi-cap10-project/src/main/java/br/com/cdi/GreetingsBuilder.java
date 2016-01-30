package br.com.cdi;

public class GreetingsBuilder {

	public String buildGreeting(final String name) {
		StringBuilder builder = new StringBuilder("Seja bem vindo ");
		builder.append(name != null ? name : "usuário");
		builder.append("!");
		return builder.toString();
	}

}
