namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Combines Converter, Scaler and Printer.</summary>
    public interface ILcdDisplay
    {
        string ToLcd(int number, Scaling scaling);
    }
}
