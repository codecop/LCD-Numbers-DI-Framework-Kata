using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Repeat objects and characters according to scaling.</summary>
    public class ScalingRepeater
    {
        public virtual IList<T> Repeat<T>(T element, Scaling scaling)
        {
            IList<T> elements = new List<T>();
            scaling.Times(() => elements.Add(element));
            return elements;
        }

        public virtual string Repeat(char aChar, Scaling scaling)
        {
            StringBuilder acc = new StringBuilder();
            scaling.Times(() => acc.Append(aChar));
            return acc.ToString();
        }
    }
}
