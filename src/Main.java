import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Object> systemObjects;
    static Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, Guardian> guardians = new HashMap<>();
    public static Map map;
    static Ride[] rides = {new Ride("Mamba Ride",100,160,12, 50, true),
                            new Ride("Giant Wheel",80,140,0, 30, false),
                             new Ride("Carrousel", 60,120,8, 15, false)};

    public static void main(String [ ] args)
    {
        systemObjects = new ArrayList<>();
        map = new Map();
        addToSystem(rides);
        int userInput = -1;
        while (userInput != 4)
        {
            System.out.println("Choose Action:");
            System.out.println("1. Register new kid");
            System.out.println("2. Display Info");
            System.out.println("3. Exit the Park");
            System.out.println("4. Exit!");

            userInput = sc.nextInt();
            sc.nextLine();

            switch (userInput) {

                // Register new kid
                case 1:
                    registerKid_UC1();
                    break;

                case 2:
                    displayCardInfo();
                    break;

                case 3:
                    exitPark();
                    break;

                default:
                    break;
            }//switch - case
        }//while - userInput != 3
        sc.close();
    }

    private static void exitPark(){
        System.out.println("Please Enter your ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (!guardians.containsKey(id)){
            System.out.println("There no child register to you!");
            return;
        }
        System.out.println("Please Enter Child name: ");
        String childName = sc.nextLine();
        if (guardians.get(id).getChild(childName) == null) {
            System.out.println("This child s not register!");
            return;
        }

        System.out.println("Please Return the child Bracelet");

        String input = "";
        while (input.compareTo("Y") != 0){
            System.out.println("Press \'Y\' to confirm and return Bracelet or \'N\' to cancel: ");
            input = sc.nextLine();
            if (input.compareTo("N") == 0)
                return;
        }
        guardians.get(id).unRegisterChild(childName);
        System.out.println("Child register Canceled Successfully!");
        System.out.println(guardians.get(id));
        if (guardians.get(id).getNumOfChildren() == 0) {
            System.out.println("Card has been Charged! \nThank you have a good Day!");
        }
    }

    private static void displayCardInfo(){
//        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your ID:");
        int id = sc.nextInt();
        sc.nextLine();
        if (!guardians.containsKey(id)) {
            System.out.println("No Child Register");
            return;
        } else
            System.out.println(guardians.get(id));
        System.out.println("Please enter Child Name:");
        String childName = sc.nextLine();

        if (guardians.get(id).getChild(childName) == null){
            System.out.println("No Child with that name Register");
            return;
        }

        ChildCard child = guardians.get(id).getChild(childName);
        System.out.println(guardians.get(id));

        int userInput = -1;
        while (userInput != 3)
        {
            System.out.println("Choose Action:");
            System.out.println("1. Add Entrances");
            System.out.println("2. Remove Entrances");
            System.out.println("3. Return to Main Menu");


            userInput = sc.nextInt();
            sc.nextLine();

            switch (userInput) {

                case 1:
                    addEntrances(child);
                    break;

                case 2:
                    removeEntrances(child, id);
                    break;

                default:
                    break;
            }//switch - case
        }//while - userInput != 3
//        sc.close();
    }

    private static void addEntrances(ChildCard child){
        Scanner sc = new Scanner(System.in);
        List<Ride> newRides = new ArrayList<>();
        String rideName = " ";
        System.out.println("Optional Rides: ");
        for (Ride ride: rides){
            if (ride.isAllowed(child))
                System.out.println(ride);
        }

        while (rideName.compareTo("") != 0){
            System.out.println("Please Enter The Ride Name or press Enter to Finish: ");
            rideName = sc.nextLine();

            Ride ride = getRide(rideName);
            if (ride == null && rideName.compareTo("") != 0)
                System.out.println("There is no Ride with that name!");
            else if (rideName.compareTo("") != 0)
                newRides.add(ride);
        }

        newRides = child.addEntrances(newRides);
        String approves = "";

        for (Ride ride: newRides)
            if (ride.isExtreme()) {
                System.out.println(ride);
                System.out.println("This Ride is Extreme, Please press Y to approve: ");
                approves = sc.nextLine();
                if (approves.compareTo("Y") != 0)
                    newRides.remove(ride);
            }

        System.out.println("Rides Added: ");
        for (Ride ride: newRides)
            System.out.println(ride);
//        sc.close();
    }

    private static void removeEntrances(ChildCard child, int id){
        System.out.println(child);
        System.out.println("Choose a ride to remove entrance from:");
        String rideToRemove = sc.nextLine();
        Ride ride = getRide(rideToRemove);

        if (ride != null)
            if (child.getOnRide(ride)) {
                System.out.println("removed success");
                child.refundGuardian(ride);
                return;
            }
        System.out.println("removed failed");
    }

    private static Ride getRide (String rideName){
        for (Ride ride: rides)
            if (ride.getRideName().compareTo(rideName) == 0)
                return ride;

        return null;
    }

    private static void registerKid_UC1()
    {
        String childName ="";
        int id = 0;
        int childAge = 0;
        boolean legalKid = false;
        //UC -1 : 1-3
        //<editor-fold> des="register kid"
        while (!legalKid)
        {
            //guardian id
            System.out.println("Please enter your ID:");
            id = sc.nextInt();
            sc.nextLine();

            System.out.println("Please enter the name of the child:");
            childName = sc.nextLine();

            //age
            System.out.println("Please enter the age of the child:");
            childAge = sc.nextInt();
            sc.nextLine();

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
        sc.nextLine();

        //Year
        System.out.println("Please enter the expiration year:");
        creditYear = sc.nextInt();
        sc.nextLine();

        //Month
        System.out.println("Please enter the expiration month:");
        creditMonth = sc.nextInt();
        sc.nextLine();

        //SafetyDigits
        System.out.println("Please enter the 3 safety digits:");
        creditSafetyDigits = sc.nextLine();

        //max amount
        System.out.println("Please enter the billing of amount limit");
        maxAmount = sc.nextInt();
        sc.nextLine();

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
        CreditCard cc1 = new CreditCard(creditNumber,creditYear,creditMonth,creditSafetyDigits, maxAmount);
        addToSystem(cc1);
        Map m1 = new Map();
        addToSystem(m1);
        Guardian g1;
        if (guardians.containsKey(id))
            g1 = guardians.get(id);
        else
            g1 = new Guardian(m1, id);
        g1.addCreditCard(cc1);
        addToSystem(g1);
        guardians.put(id, g1);
        ChildCard childCard = new ChildCard(g1,childName,childAge);
        addToSystem(childCard);
        m1.changeLocation(childCard,childCard.getLocation());
        System.out.println("**New electronic bracelet for child ID: " +childCard.getID() +"**");

        int childHeight = 0;
        int childWeight = 0;
        //height
        System.out.println("Please enter the height of the child tha device display:");
        childHeight = sc.nextInt();
        sc.nextLine();

        //weight
        System.out.println("Please enter the weight of the child that device display:");
        childWeight = sc.nextInt();
        sc.nextLine();
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
