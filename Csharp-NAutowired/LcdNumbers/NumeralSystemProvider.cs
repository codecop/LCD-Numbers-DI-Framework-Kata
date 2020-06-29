using Microsoft.Extensions.Options;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    [Service]
    public class NumeralSystemProvider
    {
        [Autowired]
        private IOptions<NumberBaseConfig> options { get; set; }

        public INumeralSystem CreateNumeralSystem()
        {
            return new NumeralSystem(10); // options.Value.Base);
        }
    }

    public class NumberBaseConfig
    {
        public int Base { get; set; }
    }

}
