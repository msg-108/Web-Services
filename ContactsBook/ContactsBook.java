
import java.util.Scanner;

public class ContactsBook{

    private static class Contact {
        String contactName;
        String contactNumber;
        String contactAddress;
        String contactEmail;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Contacts Book!");
        
        Scanner scanner = new Scanner(System.in);

        // take contact name
        System.out.println("Enter contact's name: ");
        String contactName = scanner.nextLine();

        // take contact number
        System.out.println("Enter " + contactName + "'s number: ");
        String contactNumber = scanner.nextLine();

        // take address
        System.out.println("Enter " + contactName + "'s address: ");
        String contactAddress = scanner.nextLine();

        // take email
        System.out.println("Enter " + contactName + "'s email: ");
        String contactEmail = scanner.nextLine();
        
        // create contact object
        Contact contact = new Contact();
        contact.contactName = contactName;
        contact.contactNumber = contactNumber;
        contact.contactAddress = contactAddress;
        contact.contactEmail = contactEmail;
        
        // print contact details
        System.out.println("\nContact Details:");
        System.out.println("Name: " + contact.contactName);
        System.out.println("Number: " + contact.contactNumber);
        System.out.println("Address: " + contact.contactAddress);
        System.out.println("Email: " + contact.contactEmail);
        
    }
}