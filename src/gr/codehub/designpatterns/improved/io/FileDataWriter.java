package gr.codehub.designpatterns.improved.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter implements DataWriter {

    private File file;
    private List<String> lines;

    public void setFile(File file) {
        this.file = file;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void writeData() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        lines.stream().map(s -> s + "\n").forEach(writer::write);
        writer.close();
    }
}
