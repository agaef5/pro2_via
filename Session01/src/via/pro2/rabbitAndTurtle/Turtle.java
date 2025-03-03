package via.pro2.rabbitAndTurtle;

public class Turtle implements Runnable
{
  private int walkedMeters;

  public Turtle(){
    walkedMeters = 0;
  }

  public void run(){
    while(walkedMeters <= 1000){
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException e)
      {
        System.out.println("Unfortunately, turtle has lost!");
        break;
      }
      walkedMeters += 1;
      System.out.println("Turtle has made it to " + walkedMeters + " meteres!");
    }

    if(!(walkedMeters < 1000)) System.out.println("Turtle has walked up to the finish!");
  }

  public int getWalkedMeters()
  {
    return walkedMeters;
  }
}
