public class WeightRestriction extends Restriction {

    private int maxWeight;


    public WeightRestriction() {
        this.maxWeight = 120;
    }

    public WeightRestriction(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
