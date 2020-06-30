namespace Org.Codecop.Lcdnumbers
{
    public interface ICommandLineArguments
    {
        int GetNumberToDisplay();
        Scaling GetScaling();
        bool IsHelpRequired();
    }
}
