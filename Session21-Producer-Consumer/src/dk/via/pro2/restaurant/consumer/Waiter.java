package dk.via.pro2.restaurant.consumer;

import dk.via.pro2.restaurant.shared.Customer;

import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable
{
  BlockingQueue<Customer> blockingQueue;

   public Waiter(BlockingQueue<Customer> blockingQueue){
     this.blockingQueue = blockingQueue;
   }

  @Override public void run()
  {
    try{
      Customer customer = new Customer("");
      while (!customer.getName().equalsIgnoreCase("Receptionist")){
//        take, wait if its empty
        customer = blockingQueue.take();
        if( customer != null){
          System.out.println(customer.getName() + " is taken over. Taking to a table....");
          Thread.sleep(5000);
        }
        System.out.println("All have been attended to.");
      }

    }catch (InterruptedException ie){
      ie.printStackTrace();
    }
  }
}
