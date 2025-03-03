package observers;

public class Taxi implements Listener
{
  private int id;

  public Taxi(int id){
    this.id = id;
  }

  public void reactToLight(String currentLight, String previousLight) {
    String reaction;

    if(currentLight.equals("GREEN")){
      reaction = "Taxi " + id + " drives";
    }
    else if (currentLight.equals("YELLOW"))
    {
      if(previousLight.equals("RED")) reaction = "Taxi " + id + " revs its engine";
      else reaction = "Taxi " + id + " speeds up";
    }else {
      reaction = "Taxi " + id + " stops";
    }

    System.out.println(reaction);
  }

  public void update(String currentLight, String previousLight){
    reactToLight(currentLight, previousLight);
  }

}
