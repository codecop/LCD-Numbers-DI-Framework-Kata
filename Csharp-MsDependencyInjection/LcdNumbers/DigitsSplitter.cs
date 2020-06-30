using System.Collections.Generic;
using System.Linq;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits into digits and converts digits to LCD digits.</summary>
    public class DigitsSplitter : IDigitsSplitter
    {
        private readonly INumeralSystem numeralSystem;
        private readonly IDigitFactory digitFactory;

        public DigitsSplitter(INumeralSystem numeralSystem, IDigitFactory digitFactory)
        {
          this.numeralSystem = numeralSystem;
          this.digitFactory = digitFactory;
        }

        public virtual IList<Digit> Convert(int number)
        {
            IList<int> numeralDigits = numeralSystem.DigitsOf(number);
            return numeralDigits.Select(d => digitFactory.Create(d)).ToList();
        }
    }
}
