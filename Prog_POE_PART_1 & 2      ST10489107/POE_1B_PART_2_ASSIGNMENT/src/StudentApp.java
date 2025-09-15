
public class StudentApp {
    public static void main(String[] args) {

        Student s1 = new Student("Alice", 20, new int[]{85, 90, 78});
        Student s2 = new Student("Bob", 22, new int[]{65, 70, 60});
        Student s3 = new Student("Charlie", 19, new int[]{95, 88, 92});


        Student[] students = {s1, s2, s3};


        System.out.println("=== STUDENT REPORT ===");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge());
            System.out.printf("  Average: %.2f%n", s.getAverage()); // 2 decimal places
            System.out.println("  Highest Grade: " + s.getHighest());
            System.out.println("  Lowest Grade: " + s.getLowest());
            System.out.println("---------------------------");
        }
    }
}
