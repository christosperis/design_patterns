package gr.codehub.designpatterns.improved.service;

import java.util.List;
import java.util.stream.Collectors;

public class DataConverter {

    private List<String> lines;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public List<String> convertData() {
        List<String> newLines = lines
                .stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        return newLines;
    }

}
