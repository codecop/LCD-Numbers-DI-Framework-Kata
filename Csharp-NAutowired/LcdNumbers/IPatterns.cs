using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    public interface IPatterns
    {
        IList<Line> Of(int digit);
    }
}