import java.util.HashMap;
import java.util.LinkedList;

public class Map {

    HashMap<Guardian,ChildCard> visitors;
    HashMap<ChildCard,Location> locationsOfTheChildren;

    public Map()
    {
        visitors = new HashMap<>();
        locationsOfTheChildren = new HashMap<>();
    }

    public void addVisitor(Guardian g,ChildCard c)
    {
        visitors.put(g,c);
    }


}
