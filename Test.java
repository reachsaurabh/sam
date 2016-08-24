package uk.gov.moj.cpp.outcomes.domain.event;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by saurabhkumar on 13/08/2016.
 */
public class Test {
    private static JSONObject jsonObject1 = new JSONObject("{\n" +
            "\t\"type\": \"donut\",\n" +
            "\t\"id\": \"0001\",\n" +
            "\t\"name\": \"Cake\",\n" +
            "\t\"ppu\": 0.55,\n" +
            "\t\"batters\":\n" +
            "\t\t{\n" +
            "\t\t\t\"batter\":\n" +
            "\t\t\t\t[\n" +
            "\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
            "\t\t\t\t]\n" +
            "\t\t},\n" +
            "\t\"topping\":\n" +
            "\t\t[\n" +
            "\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
            "\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
            "\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
            "\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
            "\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
            "\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
            "\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
            "\t\t]\n" +
            "}");
    private static JSONObject jsonObject2 = new JSONObject("{\n" +
            "\t\"id\": \"0001\",\n" +
            "\t\"type\": \"donut\",\n" +
            "\t\"name\": \"Cake\",\n" +
            "\t\"ppu\": 0.51,\n" +
            "\t\"batters\":\n" +
            "\t\t{\n" +
            "\t\t\t\"batter\":\n" +
            "\t\t\t\t[\n" +
            "\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
            "\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
            "\t\t\t\t]\n" +
            "\t\t},\n" +
            "\t\"topping\":\n" +
            "\t\t[\n" +
            "\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
            "\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
            "\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
            "\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
            "\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
            "\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
           // "\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
            "\t\t]\n" +
            "}");

    public static void main(String ... s)
    {
        List<String> ignoreList = new ArrayList<String>();

        boolean check = JSONUtils.areJSONEqual(jsonObject1,jsonObject2,ignoreList);
        System.out.println("JSON Objects are Equal " + check);
    }
}
