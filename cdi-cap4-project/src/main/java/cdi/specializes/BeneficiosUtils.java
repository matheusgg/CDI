package cdi.specializes;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class BeneficiosUtils {

	public void beneficioCalculado(@Observes CalculadoraBeneficios15 calculadora) {
		System.out.println("=====================> " + calculadora.calculaValorBeneficio());
	}

	public void beneficioCalculado(@Observes CalculadoraBeneficios16 calculadora) {
		System.out.println("=====================> " + calculadora.calculaValorBeneficio());
	}

	@Produces
	@Named("nomeBeneficio")
	public String geraNomeBeneficio() {
		return "VR";
	}

}
