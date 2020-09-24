package gr.codehub.designpatterns.improved.app;

import gr.codehub.designpatterns.improved.common.Constants;
import gr.codehub.designpatterns.improved.io.FileDataReader;
import gr.codehub.designpatterns.improved.service.DataChecker;
import gr.codehub.designpatterns.improved.service.DataConverter;
import gr.codehub.designpatterns.improved.service.DataWriterSelector;
import gr.codehub.designpatterns.improved.service.FileDataProcessor;

import java.io.File;
import java.io.IOException;

public class MainNewAndImproved {

    private static void runApplication() {
        System.out.println("Processing started");
        boolean ok = runProcessing();
        if (!ok) {
            System.out.println("Error in processing");
        }
        System.out.println("Processing completed");
    }

    private static boolean runProcessing() {
        boolean ok = false;
        try {
            FileDataProcessor fdp = new FileDataProcessor();
            setProcessingParameters(fdp);
            ok = fdp.process();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok;
    }

    private static void setProcessingParameters(FileDataProcessor fdp) {
        fdp.setInputFile(new File(Constants.ROOT + "source.txt"));
        fdp.setOutputFile(new File(Constants.ROOT + "output.txt"));
        fdp.setDataChecker(new DataChecker());
        fdp.setDataConverter(new DataConverter());
        fdp.setDataReader(new FileDataReader());
        fdp.setDataWriter(DataWriterSelector.createDataWriter());
    }

    public static void main(String[] args) {
        runApplication();
    }

}
