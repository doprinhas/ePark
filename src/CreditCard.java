public class CreditCard {

    String creditCardNumber;
    int expirationYear;
    int expirationMonth;
    String safetyDigits;

    public CreditCard(String creditCardNumber, int expirationYear, int expirationMonth, String safetyDigits) {
        this.creditCardNumber = creditCardNumber;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.safetyDigits = safetyDigits;
    }
}
