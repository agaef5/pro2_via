package via.pro2.clockconverter.external;

public class TemperatureModelManager implements TemperatureModel
{
  public TemperatureModelManager(){

  }

  @Override public double toCelsius(double fahrenheit)
  {
    return Temperature.fahrenheitToCelsius(fahrenheit);
  }

  @Override public double toFahrenheit(double celsius)
  {
    return Temperature.celsiusToFahrenheit(celsius);
  }
}
