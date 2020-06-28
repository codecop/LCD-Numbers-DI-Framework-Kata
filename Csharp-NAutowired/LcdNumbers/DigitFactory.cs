using System;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Creates (LCD) digits from patterns.</summary>
    public class DigitFactory
    {
        private readonly Patterns patterns;

        public DigitFactory(Patterns patterns)
        {
            if (patterns == null)
            {
                throw new ArgumentNullException(nameof(patterns));
            }

            this.patterns = patterns;
        }

        public virtual Digit Create(int digit)
        {
            return new Digit(digit, patterns);
        }
    }
}
