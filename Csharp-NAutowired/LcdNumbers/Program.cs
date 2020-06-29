using System;
using System.Collections.Generic;
using NAutowired.Core.Attributes;
using NAutowired.Console;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Configuration;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>
    /// NAutowired see https://github.com/kirov-opensource/NAutowired/blob/master/README_EN.md
    /// </summary>
    public class Program : NAutowired.Core.Startup
    {
        [Autowired]
        private readonly LcdDisplay lcdDisplay;

        public override void Run(string[] args)
        {
            if (args.Length == 0)
            {
                Console.WriteLine("Run this class to see LCD Numbers working:");
                Console.WriteLine("\nRunning via dotnet:");
                Console.WriteLine("dotnet run --project LcdNumbers 12345 2");
                return;
            }

            int number = Convert.ToInt32(args[0]);
            var scaling = args.Length > 1 ? Scaling.Of(Convert.ToInt32(args[1])) : Scaling.None;

            Console.Write(lcdDisplay.ToLcd(number, scaling));
        }

        public static void Main(string[] args)
        {
            // see https://pradeeploganathan.com/dotnet/configuration-in-a-net-core-console-application/
            var configuration = new ConfigurationBuilder()
                .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
                //.AddEnvironmentVariables()
                //.AddCommandLine(args)
                .Build();

            ConsoleHost.CreateDefaultBuilder(() =>
            {
                var serviceDescriptors = new ServiceCollection();
                serviceDescriptors.Configure<NumberBaseConfig>(configuration.GetSection("NumberBase"));

                serviceDescriptors.AddSingleton(typeof(INumeralSystem),
                    serviceProvider => serviceProvider.GetRequiredService<NumeralSystemProvider>().CreateNumeralSystem());

                return serviceDescriptors;
            }, new List<string> { "LcdNumbers" }, args).
                Build().
                Run<Program>();
        }
    }
}
