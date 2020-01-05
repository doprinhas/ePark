import java.util.HashMap;
import java.util.LinkedList;

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

    public Location getChildren(Location l)
    {
        return locationsOfTheChildren.get(c);
    }

}
