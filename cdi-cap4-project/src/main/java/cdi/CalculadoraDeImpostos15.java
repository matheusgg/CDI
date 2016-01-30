package cdi;

import cdi.qualifiers.CalculadoraVigente;
import cdi.qualifiers.util.Ano;

@CalculadoraVigente(value = Ano.ANO_2015, calculadoraNova = true)
public class CalculadoraDeImpostos15 implements CalculadoraDeImpostos {

	@Override
	public double calculaImposto() {
		return 320.0;
	}

	@Override
	public String ano() {
		return "2015";
	}

}
