package uk.gov.moj.cpp.outcomes.domain.event;

import org.apache.commons.lang3.ObjectUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

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

    private static ThreadLocal<String> valueExtracted = new ThreadLocal<>();



    public static void main(String... s) {
        List<String> ignoreList = new ArrayList<String>();
        HearingEventAdded hearingEventAdded = new HearingEventAdded();
        Wrapper tt = new Wrapper();
        //tt.setTest("ss");
        //hearingEventAdded.setTest(tt);
        Wrapper tt1 = new Wrapper();
        System.out.println("tt1" + tt1.getTest());
        tt.setTest(null);
        hearingEventAdded.setTest(tt);
        extractValue(()->hearingEventAdded.getTest().getTest()).ifPresent(s1 -> tt1.setTest(s1));



        ///optionalTypeDirName.ifPresent(typeDirName -> System.out.println(typeDirName));

        // boolean check = Objects.requireNonNull(hearingEventAdded.getTest(),"");

        //ignoreList.add("batter");
        //boolean succuss = JSONUtils.areJSONEqual(jsonObject1,jsonObject2,ignoreList);
        System.out.println("tt1" + tt1.getTest());
    }

    public static <T> Optional<T> extractValue(Supplier<T> resolver ){
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    static <T> void getValue(Optional<T> value)
    {
        if(value.isPresent())
            value.get();

    }

}
