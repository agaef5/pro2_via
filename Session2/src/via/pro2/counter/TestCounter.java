package via.pro2.counter;


public class TestCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();

    CounterIncreamenter inc1 = new CounterIncreamenter(counter, 20000);
    CounterIncreamenter inc2 = new CounterIncreamenter(counter, 20000);

    Thread t1 = new Thread(inc1, "Incrementer 1");
    Thread t2 = new Thread(inc2, "Incrementer 2");

    t1.start();
    t2.start();

    System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
  }
}
