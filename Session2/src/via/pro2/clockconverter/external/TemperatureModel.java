package via.pro2.clockconverter.external;

public interface TemperatureModel
{
  public abstract double toCelsius(double fahrenheit);
  public abstract double toFahrenheit(double celsius);
}
