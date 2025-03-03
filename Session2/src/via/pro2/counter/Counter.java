package via.pro2.counter;

public class Counter
{
  private long value;
  public Counter(){
  value = 0;
  }

  public void increment(){
    //synchronisze on the counter object
    synchronized (this){
      value++;
    }
  }

  //or we can just synchronize the entire method
  public synchronized long getValue(){
      return value;
  }
}
