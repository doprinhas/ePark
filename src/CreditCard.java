public class CreditCard {

    int creditCardNumber;
    int expirationYear;
    int expirationMonth;
    String safetyDigits;
    int maxAmount;
    int balance;

    public CreditCard(int creditCardNumber, int expirationYear, int expirationMonth, String safetyDigits, int balance) {
        this.creditCardNumber = creditCardNumber;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.safetyDigits = safetyDigits;
        this.maxAmount = maxAmount;
        this.balance = 0;
    }

    public void pay(int amount)
    {
        if( this.balance + amount < maxAmount)
        {
            System.out.println("Sorry but you cannot buy a ticket for this ride, \n This purchase is rejected, your balance is: " +(maxAmount - balance));
        }
        else
        {
            this.balance = this.balance + amount;
        }
    }

    public int needToPay()
    {
        return this.balance;
    }

}
