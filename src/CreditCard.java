public class CreditCard {

    int creditCardNumber;
    int expirationYear;
    int expirationMonth;
    String safetyDigits;

    public CreditCard(int creditCardNumber, int expirationYear, int expirationMonth, String safetyDigits) {
        this.creditCardNumber = creditCardNumber;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.safetyDigits = safetyDigits;
    }
}
