using System;
using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Combines Converter, Scaler and Printer.</summary>
    public class LcdDisplay
    {
        private readonly DigitsSplitter digitsSplitter;
        private readonly DigitScaler digitScaler;
        private readonly DigitPrinter digitPrinter;

        public LcdDisplay(DigitsSplitter digitsSplitter, DigitScaler digitScaler, DigitPrinter digitPrinter)
        {
            this.digitsSplitter = digitsSplitter;
            this.digitScaler = digitScaler;
            this.digitPrinter = digitPrinter;
        }

        public virtual string ToLcd(int number, Scaling scaling)
        {
            IList<Digit> digits = digitsSplitter.Convert(number);
            IList<Digit> scaled = digitScaler.Scale(digits, scaling);
            return digitPrinter.Render(scaled);
        }
    }
}
