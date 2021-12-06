package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFileReader {


    public String findSmallestDifferenceName(Path path) {

        String nameOfTeam = "";
        //  List<String> lines = readLines(getFilePath());
        List<String> lines = readLines(path);
        lines = filteredLines(lines, getFilteredIndexes());
        List<DataWithDifference> data = extractData(lines,
                getNamePosition(), getValue1Position(), getValue2Position());
        return findMin(data).getName();
    }

    public abstract Path getFilePath();

    public abstract List<Integer> getFilteredIndexes();

    public abstract Position getNamePosition();

    public abstract Position getValue1Position();

    public abstract Position getValue2Position();

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
