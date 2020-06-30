using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Appends lines next to each other and adds line breaks.</summary>
    public interface IDigitPrinter
    {
        string Render(IList<Digit> digits);
    }
}
