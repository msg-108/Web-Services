
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
        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine().trim();

        if (employeeName.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.println("Enter mobile number: ");
        String mobileNumber = scanner.nextLine().trim();

        System.out.println("Enter desk number: ");
        String deskNumber = scanner.nextLine().trim();   

        System.out.println("Enter employee ID: ");
        String empID = scanner.nextLine().trim();

        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine().trim();

        Employee employee = new Employee();
        employee.employeeName = employeeName;
        employee.mobileNumber = mobileNumber;
        employee.deskNumber = deskNumber;
        employee.empID = empID;
        employee.teamName = teamName;

        employees.add(employee);
        System.out.println("Employee added successfully!");

    }

    public void viewEmployee(){
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        } else {
            System.out.println("All Employees:");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println("[ " + (i+1) + " ]" + employees.get(i));
            }
        }

    }

    public void updateEmployee(){
        viewEmployee();
        if (employees.isEmpty()) return;

        System.out.println("Enter the index of the employee you want to update: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            return;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > employees.size()) {
            System.out.println("Invalid index!");
            return;
        }

        Employee employee = employees.get(index - 1);

        System.out.println("Enter the new name: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            employee.employeeName = newName;
        }

        System.out.println("Enter the new mobile number: ");
        String newMobileNumber = scanner.nextLine().trim();
        if (!newMobileNumber.isEmpty()) {
            employee.mobileNumber = newMobileNumber;
        }

        System.out.println("Enter the new desk number: ");
        String newDeskNumber = scanner.nextLine().trim();
        if (!newDeskNumber.isEmpty()) {
            employee.deskNumber = newDeskNumber;
        }

        System.out.println("Enter the new employee ID: ");
        String newEmpID = scanner.nextLine().trim();
        if (!newEmpID.isEmpty()) {
            employee.empID = newEmpID;
        }

        System.out.println("Enter the new team name: ");
        String newTeamName = scanner.nextLine().trim();
        if (!newTeamName.isEmpty()) {
            employee.teamName = newTeamName;
        }

        System.out.println("Employee updated successfully!");
        
    }

    public void deleteEmployee(){
        viewEmployee();
        if (employees.isEmpty()) return;

        System.out.println("Enter the index of the employee you want to delete: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            return;
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > employees.size()) {
            System.out.println("Invalid index!");
            return;
        }

        employees.remove(index - 1);
        employees.trimToSize();
        System.out.println("Employee deleted successfully!");
        
    }

    public void searchEmployee(){
        if(employees.isEmpty()) return;

        System.out.println("Enter the name of the employee you want to search: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        if (searchName.isEmpty()) {
            System.out.println("Search term cannot be empty!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).employeeName.toLowerCase().contains(searchName)) {
                System.out.println("Employee found!");
                System.out.println(employees.get(i));
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching employees found!");
        }
        
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