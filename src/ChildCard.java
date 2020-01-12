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

    public List<Ride> addEntrances(List<Ride> rides){
        rides = guardian.addToPayment(rides);
        for(Ride ride: rides){
            if (entrances.containsKey(ride))
                entrances.put(ride, entrances.get(ride) + 1);
            else
                entrances.put(ride, 1);
        }
        return rides;
    }

    public boolean getOnRide(Ride ride)
    {
        this.location = ride.getLocation();
        if (ride.isBroken())
        {
            System.out.println("This ride is broken: " +ride.getRideName());
            return false;
        }
        if (entrances.containsKey(ride) && entrances.get(ride) > 0) {
            if (entrances.get(ride) == 1)
                entrances.remove(ride);
            else
                entrances.put(ride, entrances.get(ride) - 1);
            return true;
        }
        else
            return false;
    }

    public void refundGuardian(Ride ride){
        guardian.refund(ride.getCost());
    }

    public void refundGuardianForReminder(){
        List<Ride> rides = new ArrayList<>(entrances.keySet());
        for (Ride ride: rides) {
            for (int i = 0; i < entrances.get(ride); i++)
                refundGuardian(ride);
            entrances.remove(ride);
        }
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String info = "Name: " + name + "\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight + "\nRides Entrances:\n";
        for (Ride ride: entrances.keySet())
            info += ride.toString() + ": " +  entrances.get(ride) + "\n";
        return info;
    }
}
