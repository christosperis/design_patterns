package gr.codehub.designpatterns.improved.service;

import java.util.List;

public class DataChecker {

    private List<String> lines;

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public boolean checkData() {
        if (!lines.get(0).toLowerCase().contains("a")){
            System.out.println("No english text, no processing done");
            return false;
        }
        else {
            return true;
        }
    }
}
