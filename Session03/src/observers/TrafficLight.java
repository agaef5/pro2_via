package observers;

import java.util.ArrayList;
import java.util.Arrays;

public class TrafficLight implements Subject, Runnable {
    private String currentLight;
    private String previousLight;
    private ArrayList<Listener> listeners;

    public TrafficLight(){
        listeners = new ArrayList<>();
    }

    public void run()
    {
        String[] lights = {"GREEN", "YELLOW", "RED"};
        int lightIndex = -1;

        for (int i = 0; i < 10; i++)
        {
          try
          {
            Thread.sleep(1000);
          }
          catch (InterruptedException e)
          {
            throw new RuntimeException(e);
          }
          previousLight = lights[lightIndex];
            lightIndex = (++lightIndex) % 3;
            currentLight = lights[lightIndex];

            System.out.println("\nLight is " + currentLight);
            update(currentLight, previousLight);
        }
    }

    @Override public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    public void update(String currentLight, String previousLight)
    {
        for (Listener listener : listeners)
        {
            listener.update(currentLight, previousLight);
        }
    }
}
