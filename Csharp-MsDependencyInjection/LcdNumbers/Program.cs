using System;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace Org.Codecop.Lcdnumbers
{
    public class Program
    {
        private readonly ICommandLineArguments arguments;
        private readonly ILcdDisplay lcdDisplay;

        public Program(ICommandLineArguments arguments, ILcdDisplay lcdDisplay)
        {
            this.arguments = arguments;
            this.lcdDisplay = lcdDisplay;
        }

        public void Run()
        {
            if (arguments.IsHelpRequired())
            {
                Console.WriteLine("Run this class to see LCD Numbers working:");
                Console.WriteLine("\nRunning the generated exe:");
                Console.WriteLine("LcdNumbers\\bin\\Debug\\netcoreapp3.0\\LcdNumbers.exe 12345 2");
                Console.WriteLine("\nRunning via dotnet:");
                Console.WriteLine("dotnet run --project LcdNumbers 12345 2");
                return;
            }

            int number = arguments.GetNumberToDisplay();
            var scaling = arguments.GetScaling();

            Console.Write(lcdDisplay.ToLcd(number, scaling));
        }

        public static void Main(string[] args)
        {
            BuildConsoleHost(args).Run();
        }

        public static Program BuildConsoleHost(string[] args)
        {
            var config = LoadConfig();

            var serviceProvider = new ServiceCollection()
                .AddLogging()
                .AddScoped<ICommandLineArguments>(_ => new CommandLineArguments(args))
                .AddSingleton<INumeralSystem>(_ => new NumeralSystem(config.NumeralSystemBase))
                .AddTransient<ILcdDisplay, LcdDisplay>()
                .AddSingleton<IDigitsSplitter, DigitsSplitter>()
                .AddScoped<IDigitFactory, DigitFactory>()
                .AddSingleton<IDigitScaler, DigitScaler>()
                .AddTransient<IDigitPrinter, DigitPrinter>()
                .AddTransient<IScalingRepeater, ScalingRepeater>()
                .AddSingleton<IPatterns, Patterns>()
                .AddScoped<IZipper, Zipper>()
                .AddSingleton<Program>()
                .BuildServiceProvider();

            return serviceProvider.GetRequiredService<Program>();
        }

        private static Config LoadConfig()
        {
            var configuration = new ConfigurationBuilder()
                .AddJsonFile("appsettings.json", optional: false, reloadOnChange: false)
                .Build();
            var config = new Config();
            configuration.Bind(config);
            return config;
        }
    }

    public class Config
    {
        public int NumeralSystemBase { get; set; }
    }
}