package via.pro2.exercises.exerciseB;

public class BurgerBar
{
  private int numberOfBurgers;
  private int maxNumberOfBurgers;

  public BurgerBar(int maxNumberOfBurgers){
    numberOfBurgers = 0;
    this.maxNumberOfBurgers = maxNumberOfBurgers;
  }

  public synchronized void makeBurger(String employeeName){
    while(numberOfBurgers >= maxNumberOfBurgers){
      try
      {
        wait();
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
    }
    numberOfBurgers++;
    System.out.println(employeeName + "just made a burger");

    notifyAll();
  }

  public synchronized void eatBurger(String who){
    while(numberOfBurgers <= 0){
      try
      {
        wait();
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
    }
    numberOfBurgers--;
    System.out.println(who + " is ready to eat a burger (" +numberOfBurgers+ " left)");
    notifyAll();
  }

  public synchronized int getNumberOfBurgers()
  {
    return numberOfBurgers;
  }
}
