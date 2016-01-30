package br.com.main;

import javax.enterprise.event.Observes;

import br.com.cdi.GreetingsBuilder;

public class GreetingsObserver {

	public void newGreeting(@Observes GreetingsBuilder builder) {
		System.out.println("A new greeting was created!");
	}

}
