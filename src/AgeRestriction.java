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
}
