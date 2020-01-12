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

    @Override
    public boolean isAllowed(ChildCard child) {
        if (child.getWeight() <= maxWeight)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Weight Restriction: " + maxWeight + "\n";
    }
}
