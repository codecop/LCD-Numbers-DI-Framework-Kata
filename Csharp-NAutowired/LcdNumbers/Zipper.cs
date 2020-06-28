using System;
using System.Collections.Generic;
using System.Linq;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Zip joins elements of collections element wise, i.e. all first elements are joined and so on.</summary>
    [Service]
    public class Zipper : IZipper
    {
        public virtual IList<R> Zip<T, R>(IList<IList<T>> collections, Func<IList<T>, R> combine)
        {
            IList<R> zipped = new List<R>();

            IList<IEnumerator<T>> iterators = collections.Select(i => i.GetEnumerator()).ToList();

            IEnumerator<T> first = iterators[0];
            while (first.MoveNext())
            {
                IList<T> nthElements = NextOfEach(iterators);
                R joined = combine(nthElements);
                zipped.Add(joined);
            }

            return zipped;
        }

        private IList<T> NextOfEach<T>(IList<IEnumerator<T>> iterators)
        {
            IList<T> nthElements = new List<T>();
            foreach (IEnumerator<T> i in iterators)
            {
                // Quick hack as we don't have IEnumerator.HasNext() in C#,
                // so the 1st iterator had already been moved to the next element
                if (iterators[0] != i)
                {
                    i.MoveNext();
                }

                nthElements.Add(i.Current);
            }
            return nthElements;
        }
    }
}
