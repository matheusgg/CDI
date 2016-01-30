package cdi;

import cdi.qualifiers.CalculadoraVigente;
import cdi.qualifiers.util.Ano;

@CalculadoraVigente(Ano.ANO_2014)
public class CalculadoraDeImpostos14 implements CalculadoraDeImpostos {

	@Override
	public double calculaImposto() {
		return 350.0;
	}

	@Override
	public String ano() {
		return "2014";
	}

}
