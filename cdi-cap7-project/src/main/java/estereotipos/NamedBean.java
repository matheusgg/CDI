package estereotipos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

/**
 * Os estereotipos no CDI servem para agrupar e padronizar um conjunto de
 * caracteristicas semelhantes, isto é, ele é aplicado em anotacoes e faz essas
 * anotacoes possuirem os mesmos comportamentos das anotacoes aplicadas a elas.
 * Essa funcionalizada é tao poderosa, que é possivel anotar uma anotacao
 * marcada por Stereotype com uma outra anotacao esteriotipa.
 * <br >
 * O CDI já disponibiliza um esteriotipo padrao chamado Model, que tem como
 * objetivo ser aplicado nos beans da camada de modelo do padrao MVC e faz com
 * que estes beans sejam nomeados e possuam o escopo de requisicao.
 * 
 * @author Matheus
 *
 */
@Named
@RequestScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NamedBean {

}
