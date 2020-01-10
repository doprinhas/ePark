import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Object> systemObjects;
    private static ArrayList<Guardian> guardians = new ArrayList<>();
    public static Map map;

    public static void main(String [ ] args)
    {
        systemObjects = new ArrayList<>();
        ArrayList<Guardian> guardians = new ArrayList<>();
        map = new Map();
        Ride[] rides = {new Ride("Mamba Ride",0,140,12),
                        new Ride("Giant Wheel",0,0,0),
                        new Ride("Carrousel", 0,0,8)};
        addToSystem(rides);
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int userInput = -1;
        while (userInput != 2)
        {
            System.out.println("Choose Action:");
            System.out.println("1. Register new kid");
            //System.out.println("2. Do something");
            System.out.println("2. Exit!");

            userInput = scanner.nextInt();

            switch (userInput) {

                // Register new kid
                case 1:
                    registerKid_UC1();
            }//switch - case
        }//while - userInput != 3

    }

    private static void registerKid_UC1()
    {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        String childName ="";
        int childAge = 0;
        boolean legalKid = false;
        //UC -1 : 1-3
        //<editor-fold> des="register kid"
        while (!legalKid)
        {
            System.out.println("Please enter the name of the child:");
            childName = sc.next();

            //age
            System.out.println("Please enter the age of the child:");
            childAge = sc.nextInt();

            if ((!childName.equals("")) && childAge > 0)
            {
                legalKid = true;
            }
            else
            {
                if (childName.equals(""))
                {
                    System.out.println("invalid Name: " + childName);
                }
                if (childAge <= 0)
                {
                    System.out.println("invalid Age: " + childAge);
                }
                System.out.println("Please enter a valid information");
            }
        }
        //</editor-fold>

        //UC -1 : 4-7
        //<editor-fold> des="register Credit Card"
        int creditNumber = 0;
        int creditYear = 0;
        int creditMonth = 0;
        String creditSafetyDigits = "";
        int maxAmount = 0;

        //credit number
        System.out.println("Please enter the credit number:");
        creditNumber = sc.nextInt();

        //Year
        System.out.println("Please enter the expiration year:");
        creditYear = sc.nextInt();

        //Month
        System.out.println("Please enter the expiration month:");
        creditMonth = sc.nextInt();

        //SafetyDigits
        System.out.println("Please enter the 3 safety digits:");
        creditSafetyDigits = sc.next();

        //max amount
        System.out.println("Please enter the billing of amount limit");
        maxAmount = sc.nextInt();

        if (creditNumber == 0 ||
                (creditYear < 2020) ||
                (creditMonth < 1 && creditMonth > 12) ||
                creditSafetyDigits.length() != 3 ||
                (maxAmount < 1 && maxAmount > 10000))
        {
            System.out.println("invalid credit card details");
            return;
        }
        System.out.println("checking card details");
        System.out.println("**valid credit card details**");
        //</editor-fold>

        //UC -1 : 8-12
        //<editor-fold> des="register and update all information
        CreditCard cc1 = new CreditCard(creditNumber,creditYear,creditMonth,creditSafetyDigits);
        addToSystem(cc1);
        Map m1 = new Map();
        addToSystem(m1);
        Guardian g1 = new Guardian(m1);
        g1.addCreditCard(cc1);
        addToSystem(g1);
        guardians.add(g1);
        ChildCard childCard = new ChildCard(g1,childName,childAge);
        addToSystem(childCard);
        m1.changeLocation(childCard,childCard.getLocation());
        System.out.println("**New electronic bracelet for child ID: " +childCard.getID() +"**");

        int childHeight = 0;
        int childWeight = 0;
        //height
        System.out.println("Please enter the height of the child tha device display:");
        childHeight = sc.nextInt();

        //weight
        System.out.println("Please enter the weight of the child that device display:");
        childWeight = sc.nextInt();
        childCard.updateHeightAndWeight(childHeight,childWeight);
        g1.addChild(childCard);
        //</editor-fold>
    }

    public static void addToSystem(Object[] objs){
        for (Object obj: objs)
            systemObjects.add(obj);
    }
    public static void addToSystem(Object obj){
        systemObjects.add(obj);
    }
}
