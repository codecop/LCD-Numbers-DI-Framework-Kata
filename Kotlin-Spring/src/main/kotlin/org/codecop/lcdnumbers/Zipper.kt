package org.codecop.lcdnumbers

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
interface Zipper {
    fun <T, R> zip(collections: Collection<Collection<T>>, combine: (List<T>)-> R): List<R>
}