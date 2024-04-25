package com.github.doraeven.commons.lang;

/**
 * Ref return a reference to a generic class
 * 
 * <p>
 * Use {@link java.lang.ref.Reference<T>} instead
 * </p>
 * 
 * <p>
 * Link {@link java.lang.ref.PhantomReference<T>},
 * {@link java.lang.ref.SoftReference<T>},
 * {@link java.lang.ref.WeakReference<T>},
 * {@link java.lang.ref.FinalReference<T>}
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
