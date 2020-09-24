package gr.codehub.designpatterns.old;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ROOT = "C:\\Users\\User\\Downloads\\design_patterns\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(ROOT + "source.txt")));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            if (!lines.get(0).toLowerCase().contains("a")){
                System.out.println("No english text, no processing done");
                System.exit(1);
            }
            PrintWriter writer = new PrintWriter(new FileWriter(new File(ROOT + "output.txt")));
            lines
                    .stream()
                    .map(s -> s.toUpperCase() + "\n")
                    .forEach(writer::write);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }
}
