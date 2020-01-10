import java.util.HashMap;
import java.util.List;

public class ChildCard {

    private String name;
    private int age;
    private double weight;
    private double height;
    private Guardian guardian;
    private Map map;
    private int ID;
    private HashMap<Ride, Integer> entrances;

    private static int ID_COUNTER = 0;

    public ChildCard(Guardian guardian, String name, int age){
        this.name = name;
        this.guardian = guardian;
        this.age = age;
        this.entrances = new HashMap<>();
        ID_COUNTER++;
        this.ID = ID_COUNTER;
    }

    public void updateHeightAndWeight(double height, double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public int getID() {
        return ID;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void addEntrances(List<Ride> rides){
        for(Ride ride: rides){
            if (entrances.containsKey(ride))
                entrances.put(ride, entrances.get(ride) + 1);
            else
                entrances.put(ride, 1);
        }
    }

    public boolean enterRide(Ride ride){
        if (entrances.containsKey(ride) && entrances.get(ride) > 0) {
            entrances.put(ride, entrances.get(ride) - 1);
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
