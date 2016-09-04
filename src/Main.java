
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Customers customer = new Customers();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome customer.");


        while (true) {

            customer.chooseName();
            customer.chooseChoice();
        }


    }


}
