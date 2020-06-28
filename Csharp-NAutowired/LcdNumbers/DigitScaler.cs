using System.Collections.Generic;
using System.Linq;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Scales x and y of digit lines.</summary>
    [Service]
    public class DigitScaler : IDigitScaler
    {
        [Autowired]
        private readonly IScalingRepeater repeater;

        public virtual IList<Digit> Scale(IList<Digit> digits, Scaling scaling)
        {
            return digits.Select(d => Scale(d, scaling)).ToList();
        }

        private Digit Scale(Digit digit, Scaling scaling)
        {
            if (scaling.HasNone())
            {
                return digit;
            }

            List<Line> scaled = new List<Line>();

            bool oddLine = true;
            foreach (Line line in digit.Lines())
            {
                Line scaledLine = line.ScaleHorizontal(repeater, scaling);
                if (oddLine)
                {
                    scaled.Add(scaledLine);
                }
                else
                {
                    scaled.AddRange(repeater.Repeat(scaledLine, scaling));
                }
                oddLine = !oddLine;
            }

            return digit.Scale(scaled);
        }
    }
}
