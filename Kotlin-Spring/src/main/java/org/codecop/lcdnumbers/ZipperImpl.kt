package org.codecop.lcdnumbers

import org.springframework.stereotype.Service
import java.util.ArrayList

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
@Service
class ZipperImpl : Zipper {
    override fun <T, R> zip(collections: Collection<Collection<T>>, combine: (List<T>) -> R): List<R> {
        val zipped: MutableList<R> = ArrayList()
        val iterators: List<Iterator<T>> = collections.map { it.iterator() }
        
        if (iterators.isEmpty()) {
            return zipped
        }
        
        val first = iterators[0]
        
        while (first.hasNext()) {
            val nthElements = nextOfEach(iterators)
            val joined = combine(nthElements)
            zipped.add(joined)
        }
        return zipped
    }
    
    private fun <T> nextOfEach(iterators: List<Iterator<T>>): List<T> {
        val nthElements: MutableList<T> = ArrayList()
        for (i in iterators) {
            nthElements.add(i.next())
        }
        return nthElements
    }
}