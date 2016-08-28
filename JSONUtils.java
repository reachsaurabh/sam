package uk.gov.moj.cpp.outcomes.domain.event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JSONUtils {

    private static Object convertJsonElement(Object elem, List<String> ignoreList) throws JSONException {
        if (elem instanceof JSONObject) {
            JSONObject obj = (JSONObject) elem;
            Iterator<String> keys = obj.keys();
            Map<String, Object> jsonMap = new HashMap<>();

            while (keys.hasNext()) {

                String key = keys.next();
                if (ignoreList.contains(key)) {
                    continue;
                } else {
                    jsonMap.put(key, convertJsonElement(obj.get(key), ignoreList));
                }
            }
            return jsonMap;
        } else if (elem instanceof JSONArray) {
            JSONArray arr = (JSONArray) elem;
            Set<Object> jsonSet = new HashSet<>();
            for (int i = 0; i < arr.length(); i++) {
                jsonSet.add(convertJsonElement(arr.get(i), ignoreList));
            }
            return jsonSet;
        } else {
            return elem;
        }
    }

    static boolean printDifference(Map<String, Object> m1, Map<String, Object> m2) {
        boolean areEqual = true;
        int size1 = m1.keySet().size();
        int size2 = m1.keySet().size();
        if (size1 >= size2) {
            for (String key : m1.keySet())
                if (!m1.get(key).equals(m2.get(key))) {
                    areEqual = false;
                    System.out.println("Key that is different :" + key);
                    if (m1.get(key) instanceof Set) {
                        Set<Object> result = symmetricDifference((Set) m1.get(key), (Set) m2.get(key));
                        result.stream().forEach(System.out::println);
                    } else {
                        System.out.println("and Value::" + m1.get(key));

                    }

                }
        } else {
            for (String key : m2.keySet())
                if (!m2.get(key).equals(m1.get(key))) {
                    areEqual = false;
                    System.out.println("Key that is different :" + key + " and Value::" + m2.get(key));
                    System.out.println("Key that is different :" + key + " and Value::" + m1.get(key));

                }
        }
        return areEqual;
    }

    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        for (T element : b) {
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }

    public boolean areJSONEqual(JSONObject ob1, JSONObject ob2, List<String> ignoreList) throws Exception {
        Object obj1Converted = convertJsonElement(ob1, ignoreList);
        Object obj2Converted = convertJsonElement(ob2, ignoreList);
        boolean areEqual = obj1Converted.equals(obj2Converted);
        if (!areEqual)
            printDifference((Map) obj1Converted, (Map) obj2Converted);
        return areEqual;
    }


}
