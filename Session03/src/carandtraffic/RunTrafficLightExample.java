package carandtraffic;

import java.util.ArrayList;
import java.util.Arrays;

public class RunTrafficLightExample {

    public static void main(String[] args) throws InterruptedException
    {
        TrafficLight trafficLight = new TrafficLight();

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(4);
        Car car5 = new Car(5);

        ArrayList<Car> cars = new ArrayList<>(
            Arrays.asList(car1, car2, car3, car4, car5));

        trafficLight.start(cars);
    }
}
