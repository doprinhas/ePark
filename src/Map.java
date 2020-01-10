import java.util.*;

public class Map {

    HashMap<ChildCard,Location> locationsOfTheChildren;

    public Map()
    {
        locationsOfTheChildren = new HashMap<>();
    }

    public void changeLocation(ChildCard c,Location l)
    {
        locationsOfTheChildren.put(c,l);
    }

    public Location getLocation(ChildCard c)
    {
        return locationsOfTheChildren.get(c);
    }


    public void displayLocation(ChildCard c)
    {
        System.out.println(c.toString() + ": " + locationsOfTheChildren.get(c).toString());
    }

    public void displayMap()
    {
        System.out.println("ePark Map: ");
        for (ChildCard c : locationsOfTheChildren.keySet())
        {
            displayLocation(c);
        }
    }

}
