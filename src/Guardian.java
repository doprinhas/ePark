import java.util.ArrayList;
import java.util.List;

public class Guardian {
    List<ChildCard> childList;
    List<CreditCard> creditCards;
    Map map;

    public Guardian(Map map)
    {
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

}
