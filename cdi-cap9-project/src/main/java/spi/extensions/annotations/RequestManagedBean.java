package spi.extensions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Named
@RequestScoped
@Stereotype
public @interface RequestManagedBean {

}
