package uk.gov.moj.cpp.outcomes.domain.event;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by saurabhkumar on 13/08/2016.
 */
public class JSONObjectComparator {
    public static boolean jsonObjsAreEqual (JSONObject js1, JSONObject js2) throws JSONException {
        if (js1 == null || js2 == null) {
            return (js1 == js2);
        }

        List<String> l1 =  Arrays.asList(JSONObject.getNames(js1));
        Collections.sort(l1);
        List<String> l2 =  Arrays.asList(JSONObject.getNames(js2));
        Collections.sort(l2);
        if (!l1.equals(l2)) {
            return false;
        }
        for (String key : l1) {
            Object val1 = js1.get(key);
            Object val2 = js2.get(key);
            if (val1 instanceof JSONObject) {
                if (!(val2 instanceof JSONObject)) {
                    return false;
                }
                if (!jsonObjsAreEqual((JSONObject)val1, (JSONObject)val2)) {
                    return false;
                }
            }

            if (val1 == null) {
                if (val2 != null) {
                    return false;
                }
            }  else if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }
}
