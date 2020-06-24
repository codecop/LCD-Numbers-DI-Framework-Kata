package org.codecop.lcdnumbers;

import java.util.Collection;
import java.util.List;

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
public interface Zipper {

    @FunctionalInterface
    public interface Combiner<T, R> {
        R combine(T t);
    }

    <T, R> List<R> zip(Collection<? extends Collection<T>> collections, Combiner<List<T>, R> combine);

}
