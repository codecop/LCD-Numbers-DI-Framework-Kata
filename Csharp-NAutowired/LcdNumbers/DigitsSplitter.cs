using System;
using System.Collections.Generic;
using System.Linq;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits into digits and converts digits to LCD digits.</summary>
    public class DigitsSplitter
    {
        private readonly NumeralSystem numeralSystem;
        private readonly DigitFactory digitFactory;

        public DigitsSplitter(NumeralSystem numeralSystem, DigitFactory digitFactory)
        {
            if (numeralSystem == null)
            {
                throw new ArgumentNullException(nameof(numeralSystem));
            }
            if (digitFactory == null)
            {
                throw new ArgumentNullException(nameof(digitFactory));
            }

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
