package Shepherd;

import java.util.HashMap;

/**
 *
 * @author arman
 */
public class ShepherdState implements Cloneable {

    public HashMap<String, Byte> locations = new HashMap<>();
    public static String SHEPHERD = "shepherd", SHEEP = "sheep", WOLF = "wolf", GRASS = "grass";

    public ShepherdState(int shepherd, int wolf, int grass, int sheep) {
        locations.put(SHEPHERD, (byte) shepherd);
        locations.put(SHEEP, (byte) sheep);
        locations.put(WOLF, (byte) wolf);
        locations.put(GRASS, (byte) grass);
    }

    @Override
    public String toString() {
        return '{' + SHEPHERD + ":" + locations.get(SHEPHERD)
                + " , " + WOLF + ":" + locations.get(WOLF)
                + " , " + GRASS + ":" + locations.get(GRASS)
                + " , " + SHEEP + ":" + locations.get(SHEEP) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ShepherdState) {
            return (((ShepherdState) o).locations.equals(locations));
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShepherdState clone = (ShepherdState) super.clone(); //To change body of generated methods, choose Tools | Templates.
        clone.locations = (HashMap<String, Byte>) locations.clone();
        return clone;
    }

    public void moveItem(String k) {
        byte b = (byte) (locations.get(k) * (-1));
        locations.put(k, b);
    }
}
