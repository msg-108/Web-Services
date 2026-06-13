
import java.util.Scanner;

public class ContactsBook{

    public static void main(String[] args) {
        System.out.println("Welcome to the Contacts Book!");
        
        Scanner scanner = new Scanner(System.in);
        
        // take contact name
        System.out.println("Enter contact's name: ");
        String contactName = scanner.nextLine();

        // take contact number
        System.out.println("Enter " + contactName + "'s number: ");
        String contactNumber = scanner.next();
        
        // take address
        System.out.println("Enter " + contactName + "'s address: ");
        String contactAddress = scanner.nextLine();

        // take email
        System.out.println("Enter " + contactName + "'s email: ");
        String contactEmail = scanner.next();
        

        // print contact details
        System.out.println("\nContact Details:");
        System.out.println("Name: " + contactName);
        System.out.println("Number: " + contactNumber);
        System.out.println("Address: " + contactAddress);
        System.out.println("Email: " + contactEmail);
    }
}