package via.pro2.exercises.exerciseB;

public class BurgerBarEmployee implements Runnable
{
  private String name;
  private BurgerBar burgerBar;

  public BurgerBarEmployee(String name, BurgerBar burgerBar){
    this.name = name;
    this.burgerBar = burgerBar;
  }

 @Override public void run(){
    while(burgerBar != null){
      burgerBar.makeBurger(name);

      try{
        Thread.sleep(2000);

      }catch (InterruptedException ie){
        ie.printStackTrace();
      }

      ;
    }
  }


}
