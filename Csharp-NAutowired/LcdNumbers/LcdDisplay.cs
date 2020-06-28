using System.Collections.Generic;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Combines Converter, Scaler and Printer.</summary>
    [Service]
    public class LcdDisplay : ILcdDisplay
    {
        [Autowired]
        private readonly IDigitsSplitter digitsSplitter;
        [Autowired]
        private readonly IDigitScaler digitScaler;
        [Autowired]
        private readonly IDigitPrinter digitPrinter;

        public virtual string ToLcd(int number, Scaling scaling)
        {
            IList<Digit> digits = digitsSplitter.Convert(number);
            IList<Digit> scaled = digitScaler.Scale(digits, scaling);
            return digitPrinter.Render(scaled);
        }
    }
}
