package gr.codehub.designpatterns.improved.service;

import gr.codehub.designpatterns.improved.io.DataReader;
import gr.codehub.designpatterns.improved.io.DataWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataProcessor {

    private DataWriter dataWriter;
    private DataConverter dataConverter;
    private DataChecker dataChecker;
    private DataReader dataReader;
    private File inputFile;
    private File outputFile;

    public void setDataWriter(DataWriter dataWriter) {
        this.dataWriter = dataWriter;
    }

    public void setDataConverter(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    public void setDataChecker(DataChecker dataChecker) {
        this.dataChecker = dataChecker;
    }

    public void setDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public boolean process() throws IOException {
        List<String> lines = readData();
        DataChecker dc = checkData(lines);
        boolean ok = dc.checkData();
        if (ok) {
            lines = covertData(lines);
            writeData(lines);
        }
        return ok;
    }

    private void writeData(List<String> lines) throws IOException {
        DataWriter dw = dataWriter;
        dw.setLines(lines);
        dw.setFile(inputFile);
        dw.writeData();
    }

    private List<String> covertData(List<String> lines) {
        DataConverter dv = dataConverter;
        dv.setLines(lines);
        lines = dv.convertData();
        return lines;
    }

    private DataChecker checkData(List<String> lines) {
        DataChecker dc = dataChecker;
        dc.setLines(lines);
        return dc;
    }

    private List<String> readData() throws IOException {
        List<String> lines = new ArrayList<>();
        DataReader dr = dataReader;
        dr.setFile(outputFile);
        lines = dr.readData();
        return lines;
    }

}
