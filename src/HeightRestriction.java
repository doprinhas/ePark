public class HeightRestriction extends Restriction {


    private int minHeight;

    public HeightRestriction() {
        this.minHeight = 100;
    }
    public HeightRestriction(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }


    @Override
    public boolean isAllowed(ChildCard child) {
        if (child.getHeight() >= minHeight)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Height Restriction: " + minHeight + "\n";
    }
}
