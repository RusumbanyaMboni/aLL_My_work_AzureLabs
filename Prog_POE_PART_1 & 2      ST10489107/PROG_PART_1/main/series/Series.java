package series;


import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    static ArrayList<Series> seriesList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public Series(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // ----------------- GETTERS -----------------
    public String getSeriesName() {
        return this.seriesName;
    }

    public int getSeriesAge() {
        return this.seriesAge;
    }

    public int getSeriesNumberOfEpisodes() {
        return this.seriesNumberOfEpisodes;
    }

    // ----------------- REQUIRED METHODS -----------------
    public static void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("------------------------");

        System.out.print("Enter the series id: ");
        String id = sc.nextLine();

        System.out.print("Enter the series name: ");
        String name = sc.nextLine();

        int age = getValidAge();

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = Integer.parseInt(sc.nextLine());

        seriesList.add(new Series(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    public static void searchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = sc.nextLine();
        Series found = findSeriesById(id);

        if (found != null) {
            System.out.println("------------------------------------");
            System.out.println("SERIES ID: " + found.seriesId);
            System.out.println("SERIES NAME: " + found.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + found.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + found.seriesNumberOfEpisodes);
            System.out.println("------------------------------------");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("------------------------------------");
        }
    }

    public static void updateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = sc.nextLine();
        Series found = findSeriesById(id);

        if (found != null) {
            System.out.print("Enter the series name: ");
            found.seriesName = sc.nextLine();

            found.seriesAge = getValidAge();

            System.out.print("Enter the number of episodes: ");
            found.seriesNumberOfEpisodes = Integer.parseInt(sc.nextLine());

            System.out.println("Series updated successfully!!!");
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    public static void deleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = sc.nextLine();
        Series found = findSeriesById(id);

        if (found != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(found);
                System.out.println("====================================");
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
                System.out.println("====================================");
            } else {
                System.out.println("Delete operation cancelled.");
            }
        } else {
            System.out.println("------------------------------------");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("------------------------------------");
        }
    }

    public static void seriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series data available.");
        } else {
            int count = 1;
            for (Series s : seriesList) {
                System.out.println("java.Series " + count);
                System.out.println("====================================");
                System.out.println("SERIES ID: " + s.seriesId);
                System.out.println("SERIES NAME: " + s.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + s.seriesAge);
                System.out.println("NUMBER OF EPISODES: " + s.seriesNumberOfEpisodes);
                System.out.println("====================================");
                count++;
            }
        }
    }

    public static void exitSeriesApplication() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    // ----------------- HELPER METHODS -----------------
    private static int getValidAge() {
        int age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String input = sc.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("!!! You have entered an incorrect series age !!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("!!! You have entered an incorrect series age !!!");
            }
        }
        return age;
    }

    private static Series findSeriesById(String id) {
        for (Series s : seriesList) {
            if (s.seriesId.equals(id)) {
                return s;
            }
        }
        return null;
    }
}
