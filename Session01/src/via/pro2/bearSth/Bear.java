package via.pro2.bearSth;

public class Bear implements Runnable
{
  private Cave cave;

  public Bear(Cave cave){
    this.cave = cave;  }

  public void run(){
    try{
      Thread.sleep(5000);
      System.out.println("Damn, Ive slept so good");
    }catch (InterruptedException ie){
      System.out.println("I am an angry bear!!!");
      cave.wakeAllBears();
    }
  }



}
