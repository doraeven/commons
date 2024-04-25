package com.github.doraeven.commons.lang;

/**
 * Ref return a reference to a generic class
 * 
 * <p>
 * Use {@link java.lang.ref.Reference} instead
 * </p>
 * 
 * <p>
 * Link {@link java.lang.ref.PhantomReference},
 * {@link java.lang.ref.SoftReference}, {@link java.lang.ref.WeakReference},
 * {@link java.lang.ref.FinalReference}
 * </p>
 * 
 * @param <T> the type parameter
 * 
 * @author motu
 *
 */
@Deprecated
public class Ref<T> {

	public Ref() {
	}

	public Ref(T value) {
		this.value = value;
	}

	public T value = null;
}
