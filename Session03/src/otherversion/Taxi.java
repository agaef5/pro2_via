package otherversion;

import observers.Listener;

public class Taxi implements Listener
{
  private int id;

  public Taxi(int id){
    this.id = id;
  }

  public void reactToLight(String currentLight) {
    String reaction = switch (currentLight) {
      case "GREEN" -> "Taxi " + id + " drives";
      case "YELLOW" -> "Taxi " + id + " speeds up";
      case "RED" -> "Taxi " + id + " stops with screeching breaks";
      default -> throw new IllegalStateException("ooops");
    };
    System.out.println(reaction);
  }

  @Override public void update(String args)
  {
    reactToLight(args);
  }
}
