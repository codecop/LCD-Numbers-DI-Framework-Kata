using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Repeat objects and characters according to scaling.</summary>
    public interface IScalingRepeater
    {
        IList<T> Repeat<T>(T element, Scaling scaling);
        string Repeat(char aChar, Scaling scaling);
    }
}
