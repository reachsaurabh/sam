package uk.gov.moj.cpp.outcomes.domain.event;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;




public class JSONWrite {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        JSONObject obj = new JSONObject();
        obj.put("Name", "crunchify.com");
        obj.put("Author", "App Shah");

        JSONArray company = new JSONArray();
        company.put("Compnay: eBay");
        company.put("Compnay: Paypal");
        company.put("Compnay: Google");
        obj.put("Company List", company);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("/Users/saurabhkumar/Documents/file1.txt")) {
            file.write(obj.toString(3));
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        }
    }
}