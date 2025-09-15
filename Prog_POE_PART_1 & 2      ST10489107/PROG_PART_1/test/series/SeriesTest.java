package series;


import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        Series.seriesList.clear();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        Series.sc = new Scanner(System.in); // refresh scanner
    }

    @Test
    void TestSearchSeries() {
        Series.seriesList.add(new Series("S1", "Breaking Bad", 16, 62));
        provideInput("S1\n");
        Series.searchSeries();
        String output = outContent.toString();
        assertTrue(output.contains("Breaking Bad"));
        assertTrue(output.contains("SERIES ID: S1"));
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        provideInput("S999\n");
        Series.searchSeries();
        assertTrue(outContent.toString().contains("was not found"));
    }

    @Test
    void TestUpdateSeries() {
        Series.seriesList.add(new Series("S1", "OldName", 12, 10));
        provideInput("S1\nNewName\n15\n20\n");
        Series.updateSeries();
        Series updated = Series.seriesList.get(0);
        Assertions.assertEquals("NewName", updated.getSeriesName());
        Assertions.assertEquals(15, updated.getSeriesAge());
        Assertions.assertEquals(20, updated.getSeriesNumberOfEpisodes());
    }

    @Test
    void TestDeleteSeries() {
        Series.seriesList.add(new Series("S1", "DeleteMe", 12, 10));
        provideInput("S1\ny\n");
        Series.deleteSeries();
        Assertions.assertTrue(Series.seriesList.isEmpty());
        assertTrue(outContent.toString().contains("WAS deleted"));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        provideInput("S999\n");
        Series.deleteSeries();
        assertTrue(outContent.toString().contains("was not found"));
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        provideInput("12\n");
        int age = invokeGetValidAge();
        assertEquals(12, age);
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        provideInput("30\n15\n");
        int age = invokeGetValidAge();
        assertEquals(15, age);
        assertTrue(outContent.toString().contains("incorrect series age"));
    }


    private int invokeGetValidAge() {
        try {
            var method = Series.class.getDeclaredMethod("getValidAge");
            method.setAccessible(true);
            return (int) method.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
