using System;
using NAutowired.Core.Attributes;

namespace Org.Codecop.Lcdnumbers
{
    public class CommandLineArguments : ICommandLineArguments
    {
        private readonly string[] args;

        public CommandLineArguments(string[] args)
        {
            this.args = args;
        }

        public bool IsHelpRequired()
        {
            return args.Length == 0;
        }

        public int GetNumberToDisplay()
        {
            return Convert.ToInt32(args[0]);
        }

        public Scaling GetScaling()
        {
            return args.Length > 1 ? Scaling.Of(Convert.ToInt32(args[1])) : Scaling.None;
        }
    }
}
