package Task1.impl;

@FunctionalInterface
public interface GenericFunction<T> {
    T apply(T t);
}
