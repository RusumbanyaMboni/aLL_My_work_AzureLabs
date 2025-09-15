import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testGetAverage() {
        int[] grades = {85, 90, 78};
        Student student = new Student("Alice", 20, grades);

        assertEquals(84.33333333333333, student.getAverage(), 0.0001);
    }

    @Test
    void testGetHighest() {
        int[] grades = {85, 90, 78};
        Student student = new Student("Alice", 20, grades);

        assertEquals(90, student.getHighest());
    }

    @Test
    void testGetLowest() {
        int[] grades = {85, 90, 78};
        Student student = new Student("Alice", 20, grades);

        assertEquals(78, student.getLowest());
    }

    @Test
    void testEmptyGrades() {
        int[] grades = {};
        Student student = new Student("Bob", 22, grades);

        assertThrows(ArrayIndexOutOfBoundsException.class, student::getHighest);
        assertThrows(ArrayIndexOutOfBoundsException.class, student::getLowest);
    }
}
