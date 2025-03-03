package via.pro2.rabbitAndTurtle;

import jdk.dynalink.linker.support.TypeUtilities;

public class Race
{
  public static void main(String[] args)
  {
    Turtle turtle = new Turtle();
    Thread turtleThread = new Thread(turtle, "Turtle");

    Rabbit rabbit = new Rabbit(turtle, turtleThread);
    Thread rabbitThread = new Thread(rabbit, "Rabbit");


    turtleThread.start();
    rabbitThread.start();
  }
}
