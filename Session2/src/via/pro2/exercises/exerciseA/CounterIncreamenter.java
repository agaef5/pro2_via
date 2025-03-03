package via.pro2.exercises.exerciseA;

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
  }
}
