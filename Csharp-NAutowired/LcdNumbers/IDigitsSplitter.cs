using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits into digits and converts digits to LCD digits.</summary>
    public interface IDigitsSplitter
    {
        IList<Digit> Convert(int number);
    }
}
