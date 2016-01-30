package cdi.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

import cdi.qualifiers.util.Ano;

/**
 * Por padrao todas as classes elegiveis para injecao no CDI possuem os
 * qualificadores Any e Default.
 * 
 * @author Matheus
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
@Qualifier
public @interface CalculadoraVigente {

	Ano value() default Ano.ANO_2014;

	/**
	 * Por padrao, o CDI considera os valores de todos os atributos de uma
	 * anotacao Qualificadora para desolver uma dependencia. Com Nonbinding, o
	 * CDI ignora o valor deste atributo e considera apenas os demais.
	 * 
	 * @return
	 */
	@Nonbinding
	boolean calculadoraNova() default false;

}
