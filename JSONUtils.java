package uk.gov.moj.cpp.outcomes.domain.event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JSONUtils {

    public static boolean areJSONEqual(Object ob1, Object ob2,List<String> ignoreList) throws JSONException {
        Object obj1Converted = convertJsonElement(ob1,ignoreList);
        Object obj2Converted = convertJsonElement(ob2,ignoreList);
        return obj1Converted.equals(obj2Converted);
    }

    private static Object convertJsonElement(Object elem,List<String> ignoreList) throws JSONException {
        if (elem instanceof JSONObject) {
            JSONObject obj = (JSONObject) elem;
            Iterator<String> keys = obj.keys();
            Map<String, Object> jsonMap = new HashMap<>();
            while (keys.hasNext()) {
                String key = keys.next();
                if(ignoreList.contains(key)) {
                    continue;
                }
                else {
                    jsonMap.put(key, convertJsonElement(obj.get(key),ignoreList));
                }
            }
            return jsonMap;
        } else if (elem instanceof JSONArray) {
            JSONArray arr = (JSONArray) elem;
            Set<Object> jsonSet = new HashSet<>();
            for (int i = 0; i < arr.length(); i++) {
                jsonSet.add(convertJsonElement(arr.get(i),ignoreList));
            }
            return jsonSet;
        } else {
            return elem;
        }
    }
}