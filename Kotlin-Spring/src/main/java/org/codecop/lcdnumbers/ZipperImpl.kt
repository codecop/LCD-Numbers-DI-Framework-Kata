package org.codecop.lcdnumbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
@Service
public class ZipperImpl implements Zipper {

    @Override
    public <T, R> List<R> zip(Collection<? extends Collection<T>> collections, Combiner<List<T>, R> combine) {
        Objects.requireNonNull(collections);
        Objects.requireNonNull(combine);

        List<R> zipped = new ArrayList<>();

        List<Iterator<T>> iterators = collections.stream(). //
                map(Iterable::iterator). //
                collect(Collectors.toList());

        if (iterators.isEmpty()) {
            return zipped;
        }

        Iterator<T> first = iterators.get(0);
        while (first.hasNext()) {
            List<T> nthElements = nextOfEach(iterators);
            R joined = combine.combine(nthElements);
            zipped.add(joined);
        }

        return zipped;
    }

    private <T> List<T> nextOfEach(List<Iterator<T>> iterators) {
        List<T> nthElements = new ArrayList<>();
        for (Iterator<T> i : iterators) {
            nthElements.add(i.next());
        }
        return nthElements;
    }
}
