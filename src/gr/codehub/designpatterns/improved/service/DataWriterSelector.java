package gr.codehub.designpatterns.improved.service;

import gr.codehub.designpatterns.improved.io.DataWriter;
import gr.codehub.designpatterns.improved.io.FileDataWriter;
import gr.codehub.designpatterns.improved.io.ScreenDataWriter;

public class DataWriterSelector {

    public static DataWriter createDataWriter() {
        if (Math.random() >= 0.5) {
            return new FileDataWriter();
        }
        else {
            return new ScreenDataWriter();
        }

    }

}
