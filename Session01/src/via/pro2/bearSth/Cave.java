package via.pro2.bearSth;

import java.util.ArrayList;
import java.util.Arrays;

public class Cave
{
  private ArrayList<Thread> sleepoingBears;

  public Cave(){
    sleepoingBears = new ArrayList<>();}

  public void addBear(Thread bear){
      sleepoingBears.add(bear);
//      bear.start();
  }

  public void wakeAllBears(){
    for (Thread bear : sleepoingBears){
      System.out.println(bear.getName() + "is interrupted");
      bear.interrupt();
    }
    sleepoingBears.clear();

  }
}
