namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Creates (LCD) digits from patterns.</summary>
    public class DigitFactory : IDigitFactory
    {
        private readonly IPatterns patterns;

        public DigitFactory(IPatterns patterns)
        {
          this.patterns = patterns;
        }

        public virtual Digit Create(int digit)
        {
            return new Digit(digit, patterns);
        }
    }
}
