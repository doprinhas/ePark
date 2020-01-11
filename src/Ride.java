public class Ride {


    private WeightRestriction weightRestriction;
    private HeightRestriction heightRestriction;
    private AgeRestriction ageRestriction;
    private String RideName;
    private Location location;
    private boolean isBroken;

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public Ride(String rideName, int weightRestriction, int heightRestriction, int ageRestriction) {
        this.RideName = rideName;
        this.weightRestriction = new WeightRestriction(weightRestriction);
        this.heightRestriction = new HeightRestriction(heightRestriction);
        this.ageRestriction = new AgeRestriction(ageRestriction);
        this.location = new Location();
        this.location.choseLocation();
        isBroken = false;
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
        String s = "Ride: " + RideName + " Need to be on top of " + weightRestriction.getMaxWeight() + " Weight, And on top of "
                +heightRestriction.getMinHeight() + " Height, And on top of " + ageRestriction.getMinAge() + " Age";
        return s;
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
}
