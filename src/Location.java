import java.util.Random;

public class Location {

    int x_location;
    int y_location;


    public Location()
    {
        this.x_location = 0;
        this.y_location = 0;
    }

    public Location(int x_location, int y_location)
    {
        this.x_location = x_location;
        this.y_location = y_location;
    }

    public void setLocation(int x, int y)
    {
        this.y_location = y;
        this.x_location = x;
    }

    public int getX_location()
    {
        return x_location;
    }

    public int getY_location()
    {
        return y_location;
    }

    private void changeLocation()
    {
        x_location = (int)(Math.random()*100)+1;
        y_location = (int)(Math.random()*100)+1;
    }

    @Override
    public String toString() {
        changeLocation();
        String toReturn = x_location + " , " +y_location;
        return toReturn;
    }
}
