package via.pro2.bearSth;

import java.util.ArrayList;
import java.util.Arrays;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Cave cave = new Cave();

    Bear bear = new Bear(cave);
    Bear bear1 = new Bear(cave);
    Bear bear2 = new Bear(cave);
    Bear bear3 = new Bear(cave);
    Bear bear4 = new Bear(cave);

    Thread bearThread = new Thread(bear);
    Thread bearThread1 = new Thread(bear1);
    Thread bearThread2 = new Thread(bear2);
    Thread bearThread3 = new Thread(bear3);
    Thread bearThread4 = new Thread(bear4);

    ArrayList<Thread> bears = new ArrayList<>(Arrays.asList(bearThread, bearThread1, bearThread2, bearThread3, bearThread4));

    for(Thread bearTHread : bears){
      cave.addBear(bearTHread);
      bearTHread.start();
    }

    PokingMan pokingMan = new PokingMan(bearThread3);
    Thread pokingManThread = new Thread(pokingMan);

    pokingManThread.start();
  }
}
