package cdi.named;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class ConfiguracoesSistema {

	@Produces
	@Named("config1")
	public String geraConfiguracao1() {
		return "Configuração 1";
	}

	@Produces
	@Named("config2")
	public int geraConfiguracao2() {
		return 100;
	}

	@Produces
	@Named
	public String geraConfiguracao3() {
		return "Configuração 3";
	}

}
