package gr.codehub.designpatterns.improved.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScreenDataWriter implements DataWriter {

    private List<String> lines;

    @Override
    public void setFile(File file) {
        // does nothing
    }

    @Override
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void writeData() throws IOException {
        lines.stream().forEach(System.out::println);
    }
}
