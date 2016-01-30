package cdi.specializes;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;

public class BeneficiosUtils2 extends BeneficiosUtils {

	/**
	 * Com Specializes, todos os qualificadores e nomes declarados com Named sao
	 * herdados, desta forma, um bean marcado com Specializes nao pode declarar
	 * um nome com Named caso um ja tenha sido declarado na super classe ou no
	 * metodo que esta sendo sobrescrito.
	 * 
	 * @see cdi.specializes.BeneficiosUtils#geraNomeBeneficio()
	 */
	@Specializes
	@Produces
	@Override
	public String geraNomeBeneficio() {
		return "VA";
	}

}
