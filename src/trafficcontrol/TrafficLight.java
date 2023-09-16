package trafficcontrol;

import java.util.Map;

public class TrafficLight {

    public enum Light {RED, GREEN, ORANGE}

    private final Map<Light, Integer> control;
    private Light light;
    private int operationTime;

    public TrafficLight(Map<Light, Integer> control, Light light) {
        this.control = control;
        this.light = light;
        operationTime = 0;
    }

    /**
     * Returns the color of the traffic light.
     *
     * @return  Red, green, or orange
     */
    public Light getLight() {
        return light;
    }

    /**
     * Operate the traffic light for a duration of <code>duration</code> time units.
     *
     * @param   duration    how long to operate the traffic light for
     */
    public void operateFor(int duration) {
        operationTime += duration;
    }
}
