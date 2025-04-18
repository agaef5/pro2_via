package via.pro2.counter;

public class CounterIncreamenter implements Runnable
{
  private Counter counter;
  private int updates;

  public CounterIncreamenter(Counter counter, int updates){
    this.counter = counter;
    this.updates = updates;
  }

  @Override public void run(){
    for(int i = 0; i < updates; i++){
      counter.increment();
    }
    System.out.println(Thread.currentThread().getName() + ":" + counter.getValue());
  }
}
