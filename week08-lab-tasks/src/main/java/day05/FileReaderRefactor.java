package day05;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderRefactor {

    public static void main(String[] args) {
        day05.FileReaderRefactor fr = new day05.FileReaderRefactor();
        int minDay = fr.findSmallestTemperatureSpread(Paths.get("week08-lab-tasks/src/main/resources/weather.dat"));

        System.out.println(minDay);

        String name = fr.findSmallestTeamDifference(Paths.get("week08-lab-tasks/src/main/resources/football.dat"));
        System.out.println(name);
    }

    public String findSmallestTeamDifference(Path filePath) {

        String nameOfTeam = "";

        List<String> lines = readLines(filePath);
        lines = filteredLines(lines, Arrays.asList(0, 18));
        List<DataWithDifference> data = extractData(lines,
                new Position(7, 22), new Position(43, 45), new Position(50, 52));
        return findMin(data).getName();
    }

    public int findSmallestTemperatureSpread(Path filePath) {
        int minDay = 0;
        List<String> lines = readLines(filePath);
        lines = filteredLines(lines, Arrays.asList(0, 1, 32));
        List<DataWithDifference> data = extractData(lines,
                new Position(2, 4), new Position(6, 8), new Position(12, 14));
        return Integer.parseInt(findMin(data).getName());


    }

    private List<String> readLines(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            return lines;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private List<String> filteredLines(List<String> lines, List<Integer> filtered) {
        List<String> result = new ArrayList<>();
        for (int counter = 0; counter < lines.size(); counter++) {
            if (!filtered.contains(counter)) {
                result.add(lines.get(counter));
            }
        }
        return result;
    }

    private List<DataWithDifference> extractData(List<String> lines,
                                                 Position namePosition, Position value1Position, Position value2Position) {
        List<DataWithDifference> result = new ArrayList<>();
        for (String line : lines) {
            String name = namePosition.getAsString(line);
            int value1 = value1Position.getAsInt(line);
            int value2 = value2Position.getAsInt(line);
            result.add(new DataWithDifference(name, value1, value2));
        }
        return result;
    }

    private DataWithDifference findMin(List<DataWithDifference> data) {
        DataWithDifference min = data.get(0);
        for (DataWithDifference item : data) {
            if (min.getDifference() > item.getDifference()) {
                min = item;
            }
        }
        return min;
    }
}
