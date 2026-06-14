
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsBook{
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> contacts = new ArrayList<>();

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

    public int displayMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. View contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Search contact");
        System.out.println("0. Exit");

        System.out.println("Enter your choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            return -1;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public void addContact() {
        // add contact
        // take contact name
        System.out.println("Enter contact's name: ");
        String contactName = scanner.nextLine().trim();
        
        if (contactName.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        // take contact number
        System.out.println("Enter " + contactName + "'s number: ");
        String contactNumber = scanner.nextLine().trim();

        // take address
        System.out.println("Enter " + contactName + "'s address: ");
        String contactAddress = scanner.nextLine().trim();

        // take email
        System.out.println("Enter " + contactName + "'s email: ");
        String contactEmail = scanner.nextLine().trim();

        Contact contact = new Contact();
        contact.contactName = contactName;
        contact.contactNumber = contactNumber;
        contact.contactAddress = contactAddress;
        contact.contactEmail = contactEmail;

        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void viewContact() {
        // view contact
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");

        } else{
            System.out.println("All Contacts:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("[ " + (i+1) + " ]" + contacts.get(i));
            }
        }
    }

    public void updateContact() {
        viewContact();
        if (contacts.isEmpty()) return;

        System.out.println("Enter the index of the contact you want to update: ");

        if (!scanner.hasNextInt()) {
        System.out.println("Invalid input! Please enter a number.");
        scanner.nextLine();
        return;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index!");
            return;
        }
        
        Contact contact = contacts.get(index - 1);

        System.out.println("Enter the new name: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            contact.contactName = newName;
        }

        System.out.println("Enter the new number: ");
        String newNumber = scanner.nextLine().trim();
        if (!newNumber.isEmpty()) {
            contact.contactNumber = newNumber;
        }

        System.out.println("Enter the new address: ");
        String newAddress = scanner.nextLine().trim();
        if (!newAddress.isEmpty()) {
            contact.contactAddress = newAddress;
        }

        System.out.println("Enter the new email: ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) {
            contact.contactEmail = newEmail;
        }
        
        System.out.println("Contact updated successfully!");
        
    }

    public void deleteContact() {
        viewContact();
        if (contacts.isEmpty()) return;

        System.out.println("Enter the index of the contact you want to delete: ");
                
        if (!scanner.hasNextInt()) {
        System.out.println("Invalid input! Please enter a number.");
        scanner.nextLine();
        return;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index!");
            return;
        }        

        contacts.remove(index - 1);
        contacts.trimToSize();
        System.out.println("Contact deleted successfully!");
        
    }

    public void searchContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }
        
        System.out.println("Enter the name of the contact you want to search: ");
        String searchName = scanner.nextLine().trim().toLowerCase();
        
        if (searchName.isEmpty()) {
            System.out.println("Search term cannot be empty!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).contactName.toLowerCase().contains(searchName)) {
                System.out.println("Contact found!");
                System.out.println(contacts.get(i));
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching contacts found!");
        }
    }
    public void run() {
        System.out.println("Welcome to the Contacts Book!");
        boolean running = true;

        while (running) {
            int choice = displayMenu();

            if (choice == -1) continue;

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new ContactsBook().run();       
    }
}