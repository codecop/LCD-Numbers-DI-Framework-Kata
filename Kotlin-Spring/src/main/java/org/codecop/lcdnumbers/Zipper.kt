package org.codecop.lcdnumbers

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
interface Zipper {
    @FunctionalInterface
    interface Combiner<T, R> {
        fun combine(t: T): R
    }
    
    fun <T, R> zip(collections: Collection<Collection<T>>, combine: (List<T>)-> R): List<R>
}