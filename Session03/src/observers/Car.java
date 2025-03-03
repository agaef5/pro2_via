package observers;

public class Car implements Listener{

    private int id;

    public Car(int id) {
        this.id = id;
    }

    public void reactToLight(String currentLight, String previousLight) {
        String reaction = switch (currentLight) {
            case "GREEN" -> "Car " + id + " drives";
            case "YELLOW" -> "Car " + id + " slows down";
            case "RED" -> "Car " + id + " stops";
            default -> throw new IllegalStateException("ooops");
        };
        System.out.println(reaction);
    }

    @Override public void update(String currentLight, String previousLight)
    {
        reactToLight(currentLight, previousLight);
    }
}


