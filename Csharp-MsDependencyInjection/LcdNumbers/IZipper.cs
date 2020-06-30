using System;
using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Zip joins elements of collections element wise, i.e. all first elements are joined and so on.</summary>
    public interface IZipper
    {
        public interface Combiner<T, R>
        {
            R Apply(T arg);
        }

        IList<R> Zip<T, R>(IList<IList<T>> collections, Func<IList<T>, R> combine);
    }
}
