
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeInfo {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();

    private static class Employee {
        String employeeName;
        String mobileNumber;
        String deskNumber;
        String empID;
        String teamName;

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeName='" + employeeName + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", deskNumber='" + deskNumber + '\'' +
                    ", empID='" + empID + '\'' +
                    ", teamName='" + teamName + '\'' +
                    '}';
        }
    }

    public int displayMenu() {
        System.out.println("1. Add employee");
        System.out.println("2. View employee");
        System.out.println("3. Update employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Search employee");
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

    public void addEmployee(){

    }

    public void viewEmployee(){

    }

    public void updateEmployee(){
        
    }

    public void deleteEmployee(){
        
    }

    public void searchEmployee(){
        
    }

    public void run () {
        System.out.println("Welcome to Employee Info!");
        boolean running = true;

        while(running){
            int choice = displayMenu();

            if (choice == -1) continue;

            switch(choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee();
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
    }

    public static void main (String[] args) {
        new EmployeeInfo().run();
    }
}