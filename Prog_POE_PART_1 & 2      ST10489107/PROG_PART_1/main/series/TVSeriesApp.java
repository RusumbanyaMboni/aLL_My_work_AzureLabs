package series;

import java.util.Scanner;

public class TVSeriesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("LATEST SERIES – 2025");
            System.out.println("****************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String choice = sc.nextLine();
            if (!choice.equals("1")) {
                System.out.println("Application exited.");
                break;
            }
            showMenu();
        }
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("1. Capture a new series.");
        System.out.println("2. Search for a series.");
        System.out.println("3. Update series age restriction.");
        System.out.println("4. Delete a series.");
        System.out.println("5. Print series report - 2025");
        System.out.println("6 Exit Application.");

        System.out.print("Enter your choice: ");
        String option = sc.nextLine();

        switch (option) {
            case "1":
                Series.captureSeries();
                break;
            case "2":
                Series.searchSeries();
                break;
            case "3":
                Series.updateSeries();
                break;
            case "4":
                Series.deleteSeries();
                break;
            case "5":
                Series.seriesReport();
                break;
            case "6":
                Series.exitSeriesApplication();
                break;
            default:
                System.out.println("Invalid option. Try again!!");
        }
    }
}
