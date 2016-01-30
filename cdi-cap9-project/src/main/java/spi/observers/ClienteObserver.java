package spi.observers;

import javax.enterprise.event.Observes;

import br.com.model.Cliente;

public class ClienteObserver {

	public void observate(@Observes Cliente cliente) {
		System.out.println(cliente);
	}

}
