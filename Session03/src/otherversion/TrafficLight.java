package otherversion;

import java.util.ArrayList;

public class TrafficLight {
    String currentLight;

    public void start(ArrayList<Car> cars, ArrayList<Pedestrian> pedestrians, ArrayList<Taxi> taxis) throws InterruptedException {
        String[] lights = {"GREEN", "YELLOW", "RED"};
        int lightIndex = -1;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            lightIndex = (++lightIndex) % 3;
            currentLight = lights[lightIndex];
            System.out.println("\nLight is " + currentLight);
            notifyCars(currentLight, cars, pedestrians, taxis);
        }
    }

    public void notifyCars(String currentLight, ArrayList<Car> cars, ArrayList<Pedestrian> pedestrians, ArrayList<Taxi> taxis){
        for (Car car : cars){
            car.reactToLight(currentLight);
        }

        for (Pedestrian pedestrian : pedestrians){
            pedestrian.reactToLight(currentLight);
        }

        for(Taxi taxi : taxis){
            taxi.reactToLight(currentLight);
        }
    }

}
