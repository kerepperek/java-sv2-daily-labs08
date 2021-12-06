package day05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TeamsFileReader extends AbstractFileReader {

    @Override
    public Path getFilePath() {
        return Paths.get("week08-lab-tasks/src/main/resources/football.dat");
    }

    @Override
    public List<Integer> getFilteredIndexes() {
        return Arrays.asList(0,18);
    }

    @Override
    public Position getValue1Position() {
        return new Position(43, 45);
    }

    @Override
    public Position getValue2Position() {
        return new Position(50, 52);
    }

    @Override
    public Position getNamePosition() {
        return new Position(7, 22);
    }
}
