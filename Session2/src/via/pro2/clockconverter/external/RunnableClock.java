package via.pro2.clockconverter.external;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable
{
  DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");;

  public RunnableClock(){

  }

  @Override public void run()
  {
    while (timeFormatter != null){
      LocalTime localTime = LocalTime.now();
      try{
        System.out.println(localTime.format(timeFormatter));
        Thread.sleep(1000);
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
    }
  }
}
