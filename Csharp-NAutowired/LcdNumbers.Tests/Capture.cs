using System;
using System.IO;

namespace Org.Codecop.Lcdnumbers.Tests
{
    class Capture
    {
        static readonly object monitor = new object();

        public static string ConsoleOutput(Action action)
        {
            lock (monitor)
            {
                var originalOut = Console.Out;

                try
                {
                    using (var stream = new MemoryStream())
                    {
                        var writer = new StreamWriter(stream);
                        Console.SetOut(writer);

                        action();

                        Console.Out.Flush();
                        stream.Position = 0;
                        var reader = new StreamReader(stream);
                        return reader.ReadToEnd();
                    }
                }
                finally
                {
                    Console.SetOut(originalOut);
                }
            }
        }
    }
}
