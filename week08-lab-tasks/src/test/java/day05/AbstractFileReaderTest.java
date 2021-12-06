package day05;

import org.junit.jupiter.api.Test;


import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractFileReaderTest {

    @Test
    void testFindSmallestTeamDifference() {

        String result = new TeamsFileReader().findSmallestDifferenceName(Paths.get("src/test/resources/football.dat"));
        assertEquals("Aston_Villa", result);
    }

    @Test
    void testFindSmallestTemperatureSpread() {

        String result = new TemperatureFileReader().findSmallestDifferenceName(Paths.get("src/test/resources/weather.dat"));
        assertEquals("14", result);
    }
}
