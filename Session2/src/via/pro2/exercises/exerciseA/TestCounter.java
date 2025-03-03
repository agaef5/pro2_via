package via.pro2.exercises.exerciseA;

public class TestCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(600, 1);

    CounterIncreamenter inc1 = new CounterIncreamenter(counter, 200);
    CounterIncreamenter inc2 = new CounterIncreamenter(counter, 200);
    CounterDecrementer dec1 = new CounterDecrementer(counter, 200);
    CounterDecrementer dec2 = new CounterDecrementer(counter, 200);

    Thread t1 = new Thread(inc1, "Incrementer 1");
    Thread t2 = new Thread(inc2, "Incrementer 2");
    Thread t3 = new Thread(dec1, "Decrementer 1");
    Thread t4 = new Thread(dec2, "Decrementer 2");


    System.out.println("Increment1 start: " +Thread.currentThread().getName() + ": " + counter.getValue());
    t1.start();
    System.out.println("Increment2 start: " +Thread.currentThread().getName() + ": " + counter.getValue());
    t2.start();
    System.out.println("Decrement1 start: " +Thread.currentThread().getName() + ": " + counter.getValue());
    t3.start();
    System.out.println("Decrement2 start" +Thread.currentThread().getName() + ": " + counter.getValue());
    t4.start();


    System.out.println("Final thread: " +Thread.currentThread().getName() + ": " + counter.getValue());
  }
}
