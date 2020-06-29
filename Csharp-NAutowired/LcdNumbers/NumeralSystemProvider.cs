using Microsoft.Extensions.Options;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    public class NumeralSystemProvider
    {
        [Autowired]
        private IOptions<NumberBaseConfig> @base { get; set; }

        public INumeralSystem CreateNumeralSystem()
        {
            return new NumeralSystem(@base.Value.Base);
        }
    }

    public class NumberBaseConfig
    {
        public int Base { get; set; }
    }

}
