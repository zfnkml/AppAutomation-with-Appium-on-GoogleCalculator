package com.google.android.calculator.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 2025, January 23, Thursday, 4:33 PM
 */

public class MyUtils {
    @DataProvider
    public Object[][] getData() throws IOException {
        ArrayList<Object[]> list = new ArrayList<>();

        String fileName = "./src/test/resources/data.csv";
        FileReader fileReader = new FileReader(fileName);
        CSVParser csvRecords = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for (CSVRecord csvRecord: csvRecords.getRecords()) {
            String input = csvRecord.get("input");
            String output = csvRecord.get("output");
            list.add(new Object[]{input,output});
        }

        csvRecords.close();

        return list.toArray(new Object[0][]);
    }
}
