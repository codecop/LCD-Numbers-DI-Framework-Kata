using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Combines Converter, Scaler and Printer.</summary>
    public class LcdDisplay : ILcdDisplay
    {
        private readonly IDigitsSplitter digitsSplitter;
        private readonly IDigitScaler digitScaler;
        private readonly IDigitPrinter digitPrinter;

        public LcdDisplay(IDigitsSplitter digitsSplitter, IDigitScaler digitScaler, IDigitPrinter digitPrinter)
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
