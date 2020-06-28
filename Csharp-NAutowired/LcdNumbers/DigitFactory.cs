using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Creates (LCD) digits from patterns.</summary>
    [Service]
    public class DigitFactory : IDigitFactory
    {
        [Autowired]
        private readonly IPatterns patterns;

        public virtual Digit Create(int digit)
        {
            return new Digit(digit, patterns);
        }
    }
}
