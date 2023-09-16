package test.design;

import org.junit.Assert;
import org.junit.Test;
import trafficcontrol.TrafficLight;
import trafficcontrol.TrafficLight.Light;

import java.util.HashMap;
import java.util.Map;

public class TestDesignProb3 {

    @Test
    public void testTrafficController() {
        Map<Light, Integer> control = new HashMap<>();
        control.put(Light.RED, 1);
        control.put(Light.GREEN, 1);
        control.put(Light.ORANGE, 1);
        TrafficLight trafficLight = new TrafficLight(control, Light.RED);
        trafficLight.operateFor(1);
        Light light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.GREEN, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.ORANGE, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.RED, light);

        trafficLight = new TrafficLight(control, Light.RED);
        trafficLight.operateFor(2);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.ORANGE, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.RED, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.GREEN, light);

        control.put(Light.RED, 2);
        control.put(Light.GREEN, 1);
        control.put(Light.ORANGE, 1);
        trafficLight = new TrafficLight(control, Light.RED);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.RED, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.GREEN, light);
        trafficLight.operateFor(1);
        light = trafficLight.getCurrentLight();
        Assert.assertEquals(Light.ORANGE, light);
    }
}
