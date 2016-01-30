package cdi.specializes;

import cdi.qualifiers.CalculadoraVigente;

@CalculadoraVigente
public class CalculadoraBeneficios15 implements CalculadoraBeneficios {

	@Override
	public double calculaValorBeneficio() {
		return 550.0;
	}

}
