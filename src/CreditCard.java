import java.util.List;

public class CreditCard {

    int creditCardNumber;
    int expirationYear;
    int expirationMonth;
    String safetyDigits;
    int maxAmount;
    int balance;

    public CreditCard(int creditCardNumber, int expirationYear, int expirationMonth, String safetyDigits, int maxAmount) {
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

    public boolean addToBalance(int amount){
        if (amount + balance > maxAmount) {
            System.out.println("Parches Wasn't Committed - Max Amount Exceeded!");
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean refund (int amount){
        if (balance - amount < 0)
            return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Credit Number: " + creditCardNumber + "\nBalance:" + balance + "\nMax Amount: " + maxAmount;
    }
}
