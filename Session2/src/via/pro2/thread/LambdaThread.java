package via.pro2.thread;

import javafx.scene.control.skin.TableHeaderRow;

//sleep and join - example
public class LambdaThread
{
  public static void main(String[] args)
  {
    Thread lt = new Thread(() -> {
      System.out.println("lt START ...");
      try {
        Thread.sleep(2000);

      } catch (InterruptedException ie){
        ie.printStackTrace();
      }

      System.out.println("Lambda thread has ended");
    });

    lt.start();

    //let the main wait
    try{
      System.out.println("<Main thread - waiting for lt to be done");
      lt.join();
      System.out.println("main thread continues");

    }catch (InterruptedException ie){
      ie.printStackTrace();
    }

  }
}
