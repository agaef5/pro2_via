package via.pro2.runnable;

public class Counter
{
  private long value;
  public Counter(){
  value = 0;
  }

  public void increment(){
    value++;
  }

  public long getValue(){
    return value;
  }
}
