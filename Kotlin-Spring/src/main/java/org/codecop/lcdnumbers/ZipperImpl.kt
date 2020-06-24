package org.codecop.lcdnumbers

import org.springframework.stereotype.Service
import java.util.ArrayList

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
@Service
class ZipperImpl : Zipper {
    override fun <T, R> zip(collections: Collection<Collection<T>>, combine: (List<T>) -> R): List<R> {
        return generateSequence(collections.map { it.iterator() }, { it })
            .takeWhile { it.all(Iterator<T>::hasNext) }
            .map { it.map(Iterator<T>::next) }
            .map(combine)
            .toList()
    }
}