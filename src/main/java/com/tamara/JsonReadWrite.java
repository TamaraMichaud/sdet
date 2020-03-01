package com.tamara;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReadWrite {

    // class not actually in use; this code (using Jackson dependency) is scattered around in MainClass

    private ObjectMapper objectMapper;

    public JsonReadWrite() {

        this.objectMapper = new ObjectMapper();
    }

    public void jsonToPojo(File fileToReadFrom, Object objectToMapTo) {
//        this.objectMapper.reader()
    }

    public void pojoToJson(File fileToWriteTo, Object objectToMapFrom) throws IOException {
        objectMapper.writeValue(fileToWriteTo, objectToMapFrom);
    }
}
