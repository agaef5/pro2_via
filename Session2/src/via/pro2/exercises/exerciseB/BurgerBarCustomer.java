package via.pro2.exercises.exerciseB;

public class BurgerBarCustomer implements Runnable
{
  private String name;
  private int burgersToEat;
  private BurgerBar burgerBar;

  public BurgerBarCustomer(String name, int burgersToEat, BurgerBar burgerBar){
    this.name = name;
    this.burgersToEat = burgersToEat;
    this.burgerBar = burgerBar;
  }

  public void run(){
    for(int i = 0; i<= burgersToEat; i++){
        try{
          Thread.sleep(5000);

        }catch (InterruptedException ie){
          ie.printStackTrace();
        }
        burgerBar.eatBurger(name);
      }
    }
  }

