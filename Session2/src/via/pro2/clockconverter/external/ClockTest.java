package via.pro2.clockconverter.external;

public class ClockTest
{
  public static void main(String[] args)
  {
    RunnableClock clock = new RunnableClock();

    Thread clockThread = new Thread(clock);
    clockThread.start();
  }
}
