package trafficcontrol;

import java.util.HashMap;
import java.util.Map;

public class TrafficLight {

    public enum Light {RED, GREEN, ORANGE}

    private final Map<Light, Integer> control;
    private Light currentLight;
    private final Map<Light, Integer> timeSpentAtLight;

    /**
     * Constructs a Traffic Light object
     *
     * @param control traffic light control
     * @param light starting light
     */
    public TrafficLight(Map<Light, Integer> control, Light light) {
        this.control = control;
        currentLight = light;
        timeSpentAtLight = new HashMap<>();
        timeSpentAtLight.put(Light.RED, 0);
        timeSpentAtLight.put(Light.GREEN, 0);
        timeSpentAtLight.put(Light.ORANGE, 0);
    }

    /**
     * Returns the color of the traffic light.
     *
     * @return  red, green, or orange
     */
    public Light getCurrentLight() {
        return currentLight;
    }

    /**
     * Operate the traffic light for a duration of <code>duration</code> time units.
     *
     * @param   duration    how long to operate the traffic light for
     */
    public void operateFor(int duration) {
        int previousTimeSpentAtCurrentLight = timeSpentAtLight.get(currentLight);
        int currentTimeSpentAtCurrentLight = previousTimeSpentAtCurrentLight + duration;
        timeSpentAtLight.put(currentLight, currentTimeSpentAtCurrentLight);
        int timeNeededToSpendAtCurrentLight = control.get(currentLight);
        while(currentTimeSpentAtCurrentLight >= timeNeededToSpendAtCurrentLight) {
            timeSpentAtLight.put(currentLight, 0);
            if (currentLight == Light.RED) {
                currentLight = Light.GREEN;
            } else if (currentLight == Light.GREEN) {
                currentLight = Light.ORANGE;
            } else if (currentLight == Light.ORANGE) {
                currentLight = Light.RED;
            }

            currentTimeSpentAtCurrentLight -= timeNeededToSpendAtCurrentLight;
            timeSpentAtLight.put(currentLight, currentTimeSpentAtCurrentLight);
            currentTimeSpentAtCurrentLight = timeSpentAtLight.get(currentLight);
            timeNeededToSpendAtCurrentLight = control.get(currentLight);
        }
    }
}
