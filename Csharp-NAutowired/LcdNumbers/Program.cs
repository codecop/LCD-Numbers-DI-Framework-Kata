using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Fake client code. Run this class to see LCD Numbers working.</summary>
    public class Program
    {
        public static void Main(string[] args)
        {
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
