using System;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>The scale factor value.</summary>
    public class Scaling
    {
        public static readonly Scaling None = new Scaling(1);
        public static readonly Scaling Two = new Scaling(2);

        private readonly int times;

        public static Scaling Of(int t)
        {
            return new Scaling(t);
        }

        private Scaling(int times)
        {
            if (times <= 0)
            {
                throw new ArgumentException("scaling factor must be >= 1");
            }

            this.times = times;
        }

        public virtual bool HasNone()
        {
            return times == 1;
        }

        public virtual void Times(Action block)
        {
            for (int i = 0; i < times; i++)
            {
                block();
            }
        }

        public override bool Equals(object other)
        {
            if (!(other is Scaling))
            {
                return false;
            }

            Scaling that = (Scaling)other;
            return this.times == that.times;
        }

        public override int GetHashCode()
        {
            return times;
        }

        public override string ToString()
        {
            return times.ToString();
        }
    }
}
