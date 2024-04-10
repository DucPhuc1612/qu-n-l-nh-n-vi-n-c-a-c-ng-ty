package gki2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Choose operation: ");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
        System.out.println("Daijoubu");
    }

    private static void addEmployee() {
        System.out.print("Enter employee details:\nID: ");
        String id = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Birth Day: ");
        String birthDay = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Employee Type (Experience/Fresher/Intern): ");
        String employeeType = scanner.nextLine();

        Employee employee = null;
        switch (employeeType) {
            case "Experience":
                System.out.print("Years of Experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Professional Skills: ");
                String proSkill = scanner.nextLine();
                employee = new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill);
                break;
            case "Fresher":
                System.out.print("Graduation Date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Graduation Rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Education: ");
                String education = scanner.nextLine();
                employee = new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
                break;
            case "Intern":
                System.out.print("Major: ");
                String majors                = scanner.nextLine();
                System.out.print("Semester: ");
                int semester = scanner.nextInt();
                scanner.nextLine();
                System.out.print("University Name: ");
                String universityName = scanner.nextLine();
                employee = new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName);
                break;
            default:
                System.out.println("Invalid employee type");
                return;
        }

        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployee() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("Employee List:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("-------------------");
        }
    }

    private static void updateEmployee() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to update.");
            return;
        }

        System.out.print("Enter the ID of the employee to update: ");
        String id = scanner.nextLine();

        for (Employee employee : employeeList) {
            if (employee instanceof Experience && employee.getId().equals(id)) {
                Experience experience = (Experience) employee;
                System.out.print("Update Years of Experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Update Professional Skills: ");
                String proSkill = scanner.nextLine();
                experience.setExpInYear(expInYear);
                experience.setProSkill(proSkill);
                System.out.println("Employee updated successfully.");
                return;
            } else if (employee instanceof Fresher && employee.getId().equals(id)) {
                Fresher fresher = (Fresher) employee;
                System.out.print("Update Graduation Date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Update Graduation Rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Update Education: ");
                String education = scanner.nextLine();
                fresher.setGraduationDate(graduationDate);
                fresher.setGraduationRank(graduationRank);
                fresher.setEducation(education);
                System.out.println("Employee updated successfully.");
                return;
            } else if (employee instanceof Intern && employee.getId().equals(id)) {
                Intern intern = (Intern) employee;
                System.out.print("Update Major: ");
                String majors = scanner.nextLine();
                System.out.print("Update Semester: ");
                int semester = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Update University Name: ");
                String universityName = scanner.nextLine();
                intern.setMajors(majors);
                intern.setSemester(semester);
                intern.setUniversityName(universityName);
                System.out.println("Employee updated successfully.");
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found.");
    }

    private static void deleteEmployee() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to delete.");
            return;
        }

        System.out.print("Enter the ID of the employee to delete: ");
        String id = scanner.nextLine();

        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                employeeList.remove(employee);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found.");
    }
}
