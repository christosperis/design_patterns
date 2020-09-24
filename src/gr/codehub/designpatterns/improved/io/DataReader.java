package gr.codehub.designpatterns.improved.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DataReader {
    public void setFile(File file);
    public List<String> readData() throws IOException;
}
