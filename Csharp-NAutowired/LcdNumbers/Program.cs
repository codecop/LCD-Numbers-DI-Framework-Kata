using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Org.Codecop.Lcdnumbers
{
    public class Program
    {
        public static void Main(string[] args)
        {
            if (args.Length == 0) {
                Console.WriteLine("Run this class to see LCD Numbers working:");
                Console.WriteLine("\nRunning via dotnet:");
                Console.WriteLine("dotnet run --project LcdNumbers 12345 2");
                return;
            }

            LcdDisplay lcdDisplay = new LcdDisplay( //
                new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), //
                new DigitScaler(new ScalingRepeater()), //
                new DigitPrinter(new Zipper()));

            int number = Convert.ToInt32(args[0]);
            Scaling scaling = Scaling.Of(Convert.ToInt32(args[1]));

            Console.WriteLine(lcdDisplay.ToLcd(number, scaling));
            Console.ReadKey();
        }
    }
}
