package via.pro2.clockconverter.external;

public class Temperature
{
  public static double fahrenheitToCelsius(double fahrenheit){
    return (fahrenheit - 32) * 5/9;
  }

  public static double celsiusToFahrenheit(double celsius){
    return (celsius * 9/5) + 32;
  }
}
