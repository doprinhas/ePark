public class Ride {

    private WeightRestriction weightRestriction;
    private HeightRestriction heightRestriction;
    private AgeRestriction ageRestriction;
    private String RideName;
    private Location location;
    private boolean isBroken;
    private boolean isExtreme;
    private int cost;

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public Ride(String rideName, int weightRestriction, int heightRestriction, int ageRestriction, int cost, boolean isExtreme) {
        this.RideName = rideName;
        this.isExtreme = isExtreme;
        this.cost = cost;
        this.weightRestriction = new WeightRestriction(weightRestriction);
        this.heightRestriction = new HeightRestriction(heightRestriction);
        this.ageRestriction = new AgeRestriction(ageRestriction);
        this.location = new Location();
        this.location.choseLocation();
        isBroken = false;
    }

    public boolean isExtreme() {
        return isExtreme;
    }

    public int getCost() {
        return cost;
    }

    public WeightRestriction getWeightRestriction() {
        return weightRestriction;
    }

    public String getRideName() {
        return RideName;
    }

    public void setRideName(String rideName) {
        RideName = rideName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        String s = "Ride: " + RideName;
        return s;
    }

    public String showRestriction(){
        return "" + ageRestriction + heightRestriction + weightRestriction;
    }

    public void setWeightRestriction(int weightRestriction) {
        this.weightRestriction =  new WeightRestriction(weightRestriction);
    }

    public HeightRestriction getHeightRestriction() {
        return heightRestriction;
    }

    public void setHeightRestriction(int heightRestriction) {
        this.heightRestriction = new HeightRestriction(heightRestriction);
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = new AgeRestriction(ageRestriction);
    }

    public boolean isAllowed (ChildCard child){
        return weightRestriction.isAllowed(child) && heightRestriction.isAllowed(child)
                && ageRestriction.isAllowed(child);
    }
}
