public class AgeRestriction extends Restriction {

    private int minAge;


    public AgeRestriction() {
        this.minAge = 7;
    }

    public AgeRestriction(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean isAllowed(ChildCard child) {
        if (child.getAge() >= minAge)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Age Restriction: " + minAge + "\n";
    }
}
