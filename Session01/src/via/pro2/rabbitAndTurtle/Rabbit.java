package via.pro2.rabbitAndTurtle;

import java.util.Random;

public class Rabbit implements Runnable
{
  public int jumpedMeters;
  private Turtle turtle;
  private Thread turtleThread;

  public Rabbit(Turtle turtle, Thread turtleThread){
    this.turtle = turtle;
    this.turtleThread = turtleThread;
    jumpedMeters = 0;
};

  public void run(){
    while (jumpedMeters <=1000 && turtleThread.isAlive()){
      if(jumpedMeters - turtle.getWalkedMeters()> 50){
        Random random = new Random();
        int randomTime = random.nextInt(1000);
        try
        {
          System.out.println("Random is going to rest for " + randomTime + " milisecodns");
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
      jumpedMeters++;
      System.out.println("Rabbit has made it to " + jumpedMeters + " meteres!");

    }

    if(turtle.getWalkedMeters() < 1000){
      System.out.println("Rabbit has won!");
      turtleThread.interrupt();
    }else{
      System.out.println("Rabbit lost!!");
    }
  }
}
