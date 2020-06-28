using System;
using System.Collections.Generic;
using System.IO;

namespace Org.Codecop.Lcdnumbers.Tests
{
    /// <summary>
    /// Shortcut methods to get input test data.
    /// </summary>
    public static class Input
    {

        public static IEnumerable<string> AllDigitsSize1()
        {
            return Read("numbers grid 3x5 - size 1.txt");
        }

        public static IEnumerable<string> AllDigitsSize2()
        {
            return Read("numbers grid 4x7 - size 2.txt");
        }

        public static IEnumerable<string> AllDigitsSize3()
        {
            return Read("numbers grid 5x9 - size 3.txt");
        }

        private static IEnumerable<string> Read(string fileName)
        {
            return File.ReadAllLines(Path.Combine(@"test-resources", fileName));
        }

        public static string join(IEnumerable<string> lines) {
            return String.Join("\n", lines) + "\n";
        }
    }
}
