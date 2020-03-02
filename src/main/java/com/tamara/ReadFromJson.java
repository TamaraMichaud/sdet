package com.tamara;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadFromJson {

    public static void main(String[] args) {

        // READING FROM JSON TO OBJECT
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerJsonRecord customerJsonRecord = null;
        try {
            customerJsonRecord = objectMapper.readValue(new File("./src/main/resources/sampleJson.json"), CustomerJsonRecord.class);
            System.out.println(customerJsonRecord.getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
