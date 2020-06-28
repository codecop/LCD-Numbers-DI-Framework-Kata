using System;
using System.Collections.Generic;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Value Object of an LCD digit.</summary>
    public class Digit
    {
        private readonly int digit;
        private readonly IList<Line> lines;

        public Digit(int digit, IPatterns patterns)
            : this(digit, patterns.Of(digit))
        {
        }

        private Digit(int digit, IList<Line> lines)
        {
            this.digit = digit;
            this.lines = lines;
        }

        public virtual IList<Line> Lines()
        {
            return lines;
        }

        public virtual Digit Scale(IList<Line> scaledLines)
        {
            int linesCount = lines.Count;
            int scaledCount = scaledLines.Count;
            if (scaledCount < linesCount)
            {
                throw new ArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
            }

            return new Digit(digit, scaledLines);
        }

        public override bool Equals(object other)
        {
            if (!(other is Digit))
            {
                return false;
            }

            Digit that = (Digit)other;
            return this.digit == that.digit;
        }

        public override int GetHashCode()
        {
            return digit;
        }

        public override string ToString()
        {
            return digit.ToString();
        }
    }
}
