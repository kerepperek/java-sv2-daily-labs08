package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderRefactorTest{

    @Test
    void testFindSmallestTeamDifference() {
        FileReaderRefactor fr = new FileReaderRefactor();
        String name = fr.findSmallestTeamDifference(Paths.get("src/test/resources/football.dat"));
        assertEquals("Aston_Villa", name);
    }

    @Test
    void testFindSmallestTemperatureSpread() {
        day05.FileReaderRefactor fr = new day05.FileReaderRefactor();
        int minDay = fr.findSmallestTemperatureSpread(Paths.get("src/test/resources/weather.dat"));
        assertEquals(14, minDay);
    }
}