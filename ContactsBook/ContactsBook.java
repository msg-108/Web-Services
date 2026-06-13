
import java.util.Scanner;

public class ContactsBook{

    private static class Contact {
        String contactName;
        String contactNumber;
        String contactAddress;
        String contactEmail;

        @Override
        public String toString() {
            return "Contact{" +
                    "contactName='" + contactName + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    ", contactAddress='" + contactAddress + '\'' +
                    ", contactEmail='" + contactEmail + '\'' +
                    '}';
        }
    }

    public static int displayMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. View contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Search contact");
        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        scanner.close();

        return choice;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Contacts Book!");
        Scanner scanner = new Scanner(System.in);

        int choice = displayMenu();

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
        System.out.println(contact);
        
    }
}