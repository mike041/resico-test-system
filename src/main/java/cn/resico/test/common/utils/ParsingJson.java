package cn.resico.test.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParsingJson {

    public static ArrayList<String> getJsonKey(String head, String json) {
        ArrayList<String> keys = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        Set<Map.Entry<String, Object>> set = jsonObject.entrySet();
        Iterator<Map.Entry<String, Object>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = iter.next();
            String key = entry.getKey();
            Object value = entry.getValue();

            keys.add(head == null ? key : head + key);
            //判断value类型
            if (value instanceof JSONObject) {
                ArrayList<String> list = getJsonKey(head == null ? key + "-" : head + key + "-", value.toString());
                keys.addAll(list);
            } else if (value instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) value;
                if (jsonArray.size() != 0) {
                    Object obj = jsonArray.get(0);
                    //对array中的类型进行判断
                    if (obj instanceof JSONObject) {
                        ArrayList<String> list = getJsonKey(head == null ? key + "-" : head + key + "-", jsonArray.get(0).toString());
                        keys.addAll(list);
                    } else {
                        keys.add(head == null ? key : head + key);
                    }
                }
            }
        }
        return keys;
    }
}
