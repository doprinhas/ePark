import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildCard {

    private String name;
    private int age;
    private double weight;
    private double height;
    private Guardian guardian;
    private Location location;
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
        this.location = new Location();
    }

    public void updateHeightAndWeight(double height, double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getID() {
        return ID;
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


    public void updateChildCard(String name,int age, double weight,double height,Guardian guardian, int ID,HashMap<Ride, Integer> entrances)
    {
        this.name = name;
        this.age =age;
        this.weight = weight;
        this.height = height;
        this.guardian = guardian;
        this.ID= ID;
        this.entrances = new HashMap<>();
        this.entrances.putAll(entrances);
        this.location = new Location();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
