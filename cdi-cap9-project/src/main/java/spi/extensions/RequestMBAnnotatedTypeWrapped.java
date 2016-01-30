package spi.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

import spi.extensions.annotations.RequestManagedBean;

public class RequestMBAnnotatedTypeWrapped<X> implements AnnotatedType<X> {

	private AnnotatedType<X> wrapped;

	public RequestMBAnnotatedTypeWrapped(AnnotatedType<X> wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public Type getBaseType() {
		return this.wrapped.getBaseType();
	}

	@Override
	public Set<Type> getTypeClosure() {
		return this.wrapped.getTypeClosure();
	}

	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return this.wrapped.getAnnotation(annotationType);
	}

	@SuppressWarnings("serial")
	@Override
	public Set<Annotation> getAnnotations() {
		Set<Annotation> annotations = new HashSet<>(this.wrapped.getAnnotations());
		annotations.add(new AnnotationLiteral<RequestManagedBean>() {
		});
		return annotations;
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		return this.wrapped.isAnnotationPresent(annotationType);
	}

	@Override
	public Class<X> getJavaClass() {
		return this.wrapped.getJavaClass();
	}

	@Override
	public Set<AnnotatedConstructor<X>> getConstructors() {
		return this.wrapped.getConstructors();
	}

	@Override
	public Set<AnnotatedMethod<? super X>> getMethods() {
		return this.wrapped.getMethods();
	}

	@Override
	public Set<AnnotatedField<? super X>> getFields() {
		return this.wrapped.getFields();
	}

}
