using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Scales x and y of digit lines.</summary>
    public interface IDigitScaler
    {
        IList<Digit> Scale(IList<Digit> digits, Scaling scaling);
    }
}
