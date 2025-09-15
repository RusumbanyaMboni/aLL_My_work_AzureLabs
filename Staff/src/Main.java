import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter current number of staff: ");
        int number = input.nextInt();
        input.nextLine();

        System.out.print("Enter staff location: ");
        String location = input.nextLine();

        StaffHiring hiring = new StaffHiring(number, location);

        System.out.println("\n--- STAFF INFORMATION ---");
        System.out.println("Staff Number: " + hiring.getStaffNumber());
        System.out.println("Staff Location: " + hiring.getStaffLocation());
        System.out.println("Hiring Process: " + hiring.getStaffHiringProcess());
    }
}
