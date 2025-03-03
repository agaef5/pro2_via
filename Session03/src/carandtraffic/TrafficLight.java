package carandtraffic;

import java.util.ArrayList;

public class TrafficLight {
    String currentLight;

    public void start(ArrayList<Car> cars) throws InterruptedException {
        String[] lights = {"GREEN", "YELLOW", "RED"};
        int lightIndex = -1;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            lightIndex = (++lightIndex) % 3;
            currentLight = lights[lightIndex];
            System.out.println("\nLight is " + currentLight);
            notifyCars(cars, currentLight);
        }
    }

    public void notifyCars(ArrayList<Car> cars, String currentLight){
        for (Car car : cars){
            car.reactToLight(currentLight);
        }
    }
}
