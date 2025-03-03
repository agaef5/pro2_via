package otherversion;

import observers.Listener;

public class Pedestrian implements Listener
{
  private int id;

  public Pedestrian(int id) {
    this.id = id;
  }

  public void reactToLight(String currentLight) {
    String reaction = switch (currentLight) {
      case "RED" -> "Pedestrain" + id + " walks";
      default -> "Pedestrian " + id + " waits";
    };
    System.out.println(reaction);
  }

  @Override public void update(String args)
  {
    reactToLight(args);
  }
}
