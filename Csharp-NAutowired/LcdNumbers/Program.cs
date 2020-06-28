using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.Extensions.DependencyInjection;
using NAutowired.Core.Attributes;
using NAutowired.Console;

namespace Org.Codecop.Lcdnumbers
{
    public class Program : NAutowired.Core.Startup
    {
        [Autowired]
        private readonly LcdDisplay lcdDisplay;

        public override void Run(string[] args)
        {
            if (args.Length == 0) {
                Console.WriteLine("Run this class to see LCD Numbers working:");
                Console.WriteLine("\nRunning via dotnet:");
                Console.WriteLine("dotnet run --project LcdNumbers 12345 2");
                return;
            }

            int number = Convert.ToInt32(args[0]);
            Scaling scaling = Scaling.Of(Convert.ToInt32(args[1]));

            Console.WriteLine(lcdDisplay.ToLcd(number, scaling));
            Console.ReadKey();
        }

        public static void Main(string[] args)
        {
            ConsoleHost.CreateDefaultBuilder(new List<string> {  "LcdNumbers" }, args).
                Build().
                Run<Program>();
        }
    }
}
