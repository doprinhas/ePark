public class Ride {


    private WeightRestriction weightRestriction;
    private HeightRestriction heightRestriction;
    private AgeRestriction ageRestriction;

    public Ride(int weightRestriction, int heightRestriction, int ageRestriction) {
        this.weightRestriction = new WeightRestriction(weightRestriction);
        this.heightRestriction = new HeightRestriction(heightRestriction);
        this.ageRestriction = new AgeRestriction(ageRestriction);
    }

    public WeightRestriction getWeightRestriction() {
        return weightRestriction;
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
