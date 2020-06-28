using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Knows the initial pattern of each LCD digit.</summary>
    public interface IPatterns
    {
        IList<Line> Of(int digit);
    }
}