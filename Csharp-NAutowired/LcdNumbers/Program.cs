using System;
using System.Collections.Generic;
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

            Console.Write(lcdDisplay.ToLcd(number, scaling));
        }

        public static void Main(string[] args)
        {
            ConsoleHost.CreateDefaultBuilder(new List<string> {  "LcdNumbers" }, args).
                Build().
                Run<Program>();
        }
    }
}
