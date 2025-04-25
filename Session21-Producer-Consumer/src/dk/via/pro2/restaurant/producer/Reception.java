package dk.via.pro2.restaurant.producer;

import dk.via.pro2.restaurant.shared.Customer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Reception implements Runnable
{
  BlockingQueue<Customer> blockingQueue;

  public Reception(BlockingQueue<Customer> blockingQueue){
    this.blockingQueue = blockingQueue;
  }



  @Override public void run()
  {
    String [] customers = {"Mihail", "Nancy", "Mario", "Youssef", "Alessia", "Jan", "Wilber", "Viacheslav", "Wiktoria", "Alisa", "Lee"};
    System.out.println(customers.length + " customers waiting...");
    for (String customersName : customers){
      try{
        Thread.sleep(1000);
        blockingQueue.put(new Customer(customersName));
        System.out.println("Put " + customersName + " in the queue");
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
      System.out.println("No more customers in the queue");
      try{
        Thread.sleep(1000);
        blockingQueue.put(new Customer("Receptionist"));
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
    }
  }

}
