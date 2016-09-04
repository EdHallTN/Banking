import java.util.HashMap;

/**
 * Created by EdHall on 9/4/16.
 *}
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EdHall on 9/1/16.
 */
public class Customers {
    public Double withdrawalAmount;
    public String name;
    public String choice;
    public String userInput;
    public String depositAmount;
    public Double newBalance;


    public HashMap<String, Double> customerBalances = new HashMap<>();

    public Customers() {

        final Double Bill = customerBalances.put("Bill", 90.57);
        final Double Mary = customerBalances.put("Mary", 44.65);
        final Double Becca = customerBalances.put("Becca", 78.89);
        final Double Frank = customerBalances.put("Frank", 55.05);
    }

    public void chooseName() {
        System.out.println("What is your name?");
        choice = "0";
        name = Main.scanner.nextLine();

        if (customerBalances.containsKey(name)) {
            System.out.println("Welcome, " + name + ".");
        } else {
            System.out.println("You do not have an account. Would you like to create one: [Y or N]?");
            userInput = Main.scanner.nextLine();

            if (userInput.equalsIgnoreCase("Y")) {
                System.out.println("How much would you like to deposit?");
                depositAmount = Main.scanner.nextLine();
                customerBalances.put(name, Double.parseDouble(depositAmount));

            }
            else {
                System.out.println("Thanks and come again.\n");
                chooseName();
            }
        }
    }


    public void chooseChoice() {

        while (Integer.parseInt(this.choice) != 3) {
            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to check your balance");
            System.out.println("Enter 2 to withdraw funds");
            System.out.println("Enter 3 to cancel");
            System.out.println("Enter 4 to delete account.");

            this.choice = Main.scanner.nextLine();

            if (Integer.parseInt(this.choice) == 1) {
                System.out.println("Your balance is " + "$" + customerBalances.get(name) + ".");

            } else if (Integer.parseInt(this.choice) == 2) {
                System.out.println("How much would you like to withdraw?");
                withdrawalAmount = Double.parseDouble(Main.scanner.nextLine());

                if(withdrawalAmount <= customerBalances.get(name)){
                    System.out.println("Please take your money.");
                    newBalance = customerBalances.get(name) - withdrawalAmount;
                    System.out.println("Your remaining balance is " + "$" + (customerBalances.get(name) - withdrawalAmount) + ".");
                    customerBalances.put(name, newBalance);
                } else {
                    System.out.println("Invalid choice: Insufficient Funds");
                }
            } else if (Integer.parseInt(this.choice) == 3) {
                System.out.println("Goodbye. Have a nice day!");
            }
            else if (Integer.parseInt(this.choice) == 4) {
                System.out.println("Your account has been deleted.");
                customerBalances.remove(name);
                choice = "3";
            }
        }
    }
}