package via.pro2.exercises.exerciseB;

import java.util.ArrayList;
import java.util.Arrays;

public class BurgerTestClass
{
  public static void main(String[] args)
  {
    BurgerBar burgerBar = new BurgerBar(20);
    BurgerBarEmployee employee1 = new BurgerBarEmployee("Momo", burgerBar);
    BurgerBarEmployee employee2 = new BurgerBarEmployee("Dodo", burgerBar);

    BurgerBarCustomer customer1 = new BurgerBarCustomer("Jiji", 10, burgerBar);
    BurgerBarCustomer customer2 = new BurgerBarCustomer("Bibi", 2, burgerBar);
    BurgerBarCustomer customer3 = new BurgerBarCustomer("Lili", 4, burgerBar);
    BurgerBarCustomer customer4 = new BurgerBarCustomer("Bobo", 3, burgerBar);
    BurgerBarCustomer customer5 = new BurgerBarCustomer("Rikikiki", 1, burgerBar);

    Thread t1 = new Thread(employee1, employee1.toString());
    Thread t2 = new Thread(employee2, employee2.toString());
    Thread t3 = new Thread(customer1, customer1.toString());
    Thread t4 = new Thread(customer2, customer2.toString());
    Thread t5 = new Thread(customer3, customer3.toString());
    Thread t6 = new Thread(customer4, customer4.toString());
    Thread t7 = new Thread(customer5, customer5.toString());

    ArrayList<Thread> threads = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
    for(Thread thread : threads) thread.start();
  }
}
