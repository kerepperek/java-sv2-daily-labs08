package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        int minDay = fr.findSmallestTemperatureSpread(Paths.get("week08-lab-tasks/src/main/resources/weather.dat"));

        System.out.println(minDay);

        String name = fr.findSmallestDifference(Paths.get("week08-lab-tasks/src/main/resources/football.dat"));
        System.out.println(name);
    }

    public String findSmallestDifference(Path filePath) {

        String nameOfTeam = "";
        try {
            List<String> lines = Files.readAllLines(filePath);
            int minDiff = -1;

            for (int counter = 1; counter < lines.size(); counter++) {
                if (!lines.get(counter).trim().startsWith("-")) {
                    int points1 = Integer.parseInt(lines.get(counter).substring(43, 46).trim());
                    int points2 = Integer.parseInt(lines.get(counter).substring(50, 53).trim());

                    String name = lines.get(counter).substring(7, 20).trim();

                    if (minDiff==-1||minDiff > Math.abs(points1 - points2)) {
                        minDiff = Math.abs(points1 - points2);
                        nameOfTeam = name;

                    }
                }
            }
            System.out.println(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return nameOfTeam;


    }

    public int findSmallestTemperatureSpread(Path filePath) {
        int minDay = 0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            int minDiff = -1;

            for (int counter = 2; counter < lines.size() - 1; counter++) {

                int day = Integer.parseInt(lines.get(counter).substring(2, 4).trim());
                int min = Integer.parseInt(lines.get(counter).substring(6, 8).trim());
                int max = Integer.parseInt(lines.get(counter).substring(12, 14).trim());
                if (minDiff==-1||minDiff > max - min) {
                    minDiff = max - min;
                    minDay = day;
                }

            }
            System.out.println(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return minDay;
    }

}
