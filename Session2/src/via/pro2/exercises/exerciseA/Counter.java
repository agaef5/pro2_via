package via.pro2.exercises.exerciseA;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long max, long min){
    value = 0;
    this.max = max;
    this.min = min;
  }

  public synchronized void increment(){

    try{
      while(value >= max) wait();
      value ++;
      System.out.println(value + ": " + Thread.currentThread().getName());
      notifyAll();

    } catch (InterruptedException ie){
      ie.printStackTrace();
    }

  }

  public synchronized void decrement(){
    try{
      while(value <= min) wait();
      value--;
      System.out.println(value + ": " + Thread.currentThread().getName());
      notifyAll();

    } catch (InterruptedException ie){
      ie.printStackTrace();
    }
  }

  public synchronized long getValue(){
      return value;
  }
}
