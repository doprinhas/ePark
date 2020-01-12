import java.util.ArrayList;
import java.util.List;

public class Guardian {
    private int id;
    List<ChildCard> childList;
    List<CreditCard> creditCards;
    Map map;

    public Guardian(Map map, int id)
    {
        this.id = id;
        this.map = map;
        this.childList = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }

    public void addChild(ChildCard child)
    {
        if(child != null)
            this.childList.add(child);
    }

    public void addCreditCard(CreditCard card)
    {
        if(card != null)
            this.creditCards.add(card);
    }

    public void updateGuardian(ChildCard childCard,CreditCard creditCard, Map map)
    {
        this.map = map;
        this.childList = new ArrayList<>();
        this.creditCards = new ArrayList<>();
        this.childList.add(childCard);
        this.creditCards.add(creditCard);
    }

    public int getNumOfChildren(){
        return childList.size();
    }

    public ChildCard getChild (String name){
        for (ChildCard child: childList)
            if (child.getName().compareTo(name) == 0)
                return child;
        return null;
    }

    public boolean unRegisterChild (String childName){
        ChildCard child = getChild(childName);
        if (child == null)
            return false;
        child.refundGuardianForReminder();
        childList.remove(getChild(childName));
        return true;
    }

    public List<Ride> addToPayment (List<Ride> rides){
        CreditCard card = creditCards.get(0);
        List<Ride> payed = new ArrayList<>();
        for (Ride ride: rides)
            if (card.addToBalance(ride.getCost()))
                payed.add(ride);

        return payed;
    }

    public void refund (int amount){
        creditCards.get(0).refund(amount);
    }

    @Override
    public String toString() {
        String info = id + ":\nCredit Info:" + creditCards.get(0) + "\n";
        for (ChildCard child: childList)
            info += child.toString() + "\n";
        return info;
    }
}
