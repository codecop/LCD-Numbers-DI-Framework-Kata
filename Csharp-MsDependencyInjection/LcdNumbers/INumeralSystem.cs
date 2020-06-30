using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits a number into its digits according to its numeral system, e.g. Decimal System.</summary>
    public interface INumeralSystem
    {
        IList<int> DigitsOf(int value);
    }
}
