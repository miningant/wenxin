package cn.shhuifu.analyse.beans;

import java.util.HashMap;
import java.util.Map;

public class ResMap {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public static Map<String, Object> resultMap(String code) {
        Map<String, Object> result = new HashMap<String, Object> ();
        result.put("code", code);
        return result;
    }

    public static Map<String, Object> resultMap(String code, Object o) {
        Map<String, Object> result = new HashMap<String, Object> ();
        result.put("code", code);
        result.put("result", o);
        return result;
    }

    public static Map<String, Object> resultMap(String code, Object o, long total) {
        Map<String, Object> result = new HashMap<String, Object> ();
        result.put("code", code);
        result.put("result", o);
        result.put("total",total);
        return result;
    }
}
