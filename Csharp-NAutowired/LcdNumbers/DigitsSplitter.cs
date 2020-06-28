using System;
using System.Collections.Generic;
using System.Linq;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits into digits and converts digits to LCD digits.</summary>
    [Service]
    public class DigitsSplitter
    {
        [Autowired]
        private readonly NumeralSystem numeralSystem;
        [Autowired]
        private readonly DigitFactory digitFactory;

        public virtual IList<Digit> Convert(int number)
        {
            IList<int> numeralDigits = numeralSystem.DigitsOf(number);
            return numeralDigits.Select(d => digitFactory.Create(d)).ToList();
        }
    }
}
