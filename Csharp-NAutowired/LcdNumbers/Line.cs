using System;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Value Object of an LCD digit line.</summary>
    public class Line
    {
        private readonly string line;

        public Line(string line)
        {
            if (line == null)
            {
                throw new ArgumentNullException(nameof(line));
            }

            this.line = line;
        }

        public virtual Line ScaleHorizontal(ScalingRepeater repeater, Scaling scaling)
        {
            if (repeater == null)
            {
                throw new ArgumentNullException(nameof(repeater));
            }
            if (scaling == null)
            {
                throw new ArgumentNullException(nameof(scaling));
            }

            char[] chars = line.ToCharArray();
            return new Line(chars[0] + repeater.Repeat(chars[1], scaling) + chars[2]);
        }

        public override bool Equals(object other)
        {
            if (!(other is Line))
            {
                return false;
            }

            Line that = (Line)other;
            return this.line.Equals(that.line);
        }

        public override int GetHashCode()
        {
            return line.GetHashCode();
        }

        public override string ToString()
        {
            return line;
        }
    }
}
