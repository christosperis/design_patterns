package gr.codehub.designpatterns.improved.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DataWriter {

    public void setFile(File file);
    public void setLines(List<String> lines);
    public void writeData() throws IOException;

}
