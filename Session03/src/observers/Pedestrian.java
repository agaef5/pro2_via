package observers;

public class Pedestrian implements Listener
{
  private int id;

  public Pedestrian(int id) {
    this.id = id;
  }

  public void reactToLight(String currentLight, String previousLight) {
    String reaction;

    if(currentLight.equals("GREEN")){
      reaction = "Pedestrian " + id + " waits";
    }
    else if (currentLight.equals("YELLOW"))
    {
      if(previousLight.equals("RED")) reaction = "Pedestrian " + id + " runs across the road";
      else reaction = "Pedestrian " + id + "gets ready to cross the road";
    }else {
      reaction = "Pedestrian " + id + " crosses the street";
    }

    System.out.println(reaction);
  }

  public void update(String currentLight, String previousLight){
    reactToLight(currentLight, previousLight);
  }
}
