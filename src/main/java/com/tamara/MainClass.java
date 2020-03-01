package com.tamara;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//        Class.forName("com.mysql.cj.jdbc.Driver"); // same as import statement...?
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

        ResultSet queryResults = conn.createStatement()
                .executeQuery("select * from Business.CustomerInfo");

        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomerDbRecord> customerDbRecordList = new ArrayList<>();
        // this is using json.simple dependency <<< AND IS AWFUL!!!
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();

        int x = 0;
        while (queryResults.next()) {

            CustomerDbRecord nextRecord = new CustomerDbRecord();
            nextRecord.setTitle(queryResults.getString(1));
            nextRecord.setPurchaseDate(queryResults.getDate(2));
            nextRecord.setPrice(queryResults.getInt(3));
            nextRecord.setCountry(queryResults.getString(4));

            customerDbRecordList.add(nextRecord);
//            String jsonString = new Gson().toJson(nextRecord);
//            jsonArray.add(jsonString);
            objectMapper.writeValue(new File("myjsonfile" + x + ".json"), nextRecord);
            x++;
        }

        // we can just print the array into a single file too
        objectMapper.writeValue(new File("myjsonfile.json"), customerDbRecordList);
//        System.out.println(customerDbRecordList.toString());

        // this comes from apache commons-text dependency.
        // our jsonArray string has ->  \"value\": .. etc
//        String s = StringEscapeUtils.unescapeJson(jsonArray.toJSONString())
//                .replace("\"{", "{")
//                .replace("}\"", "}");
// ^^ rubbish util; each pojo is surrounded by extra quotes; curly braces should be alone...

// NO TO ALL OF THIS!! DEEPLY UNIMPRESSED!

//        jsonObject.put("data", jsonArray);
//        jsonObject.put("data2", s);

//        String s = StringEscapeUtils.unescapeJson(jsonObject.toJSONString())
//                .replace("\"{", "{")
//                .replace("}\"", "}");
//        String s = StringEscapeUtils.unescapeJson(jsonObject.toJSONString().replaceAll("^\"", "").replaceAll("\"$", ""))
//                .replace("\"{", "{")
//                .replace("}\"", "}");
// ^^ no, this is a total turd!!!

//        objectMapper.writeValue(new File("myjsonfile" + "EEHHH" + ".json"), s);


        conn.close();
    }
}
