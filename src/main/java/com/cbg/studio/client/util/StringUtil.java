package com.cbg.studio.client.util;

import java.util.List;

public class StringUtil {
    public static String wrapString(String text, String token) {
        String result = token + text + token;

        return result;
    }

    public static String jsonWrapString(String text) {
        return wrapString(text, "\"");
    }

    public static String serializeList(List<?> list) {
        StringBuilder b = new StringBuilder();

        int size = list.size();
        int x = 0;
        for (Object o : list) {
            b.append(o.toString());

            if (x + 1 != size) {
                b.append(",");
            }
        }

        return b.toString();
    }

    public static String serializeJsonList(List<?> list) {
        StringBuilder b = new StringBuilder();

        b.append("[").append(serializeList(list)).append("]");

        return b.toString();
    }

    public static String implodeJson(List<String> list) {
        return implodeJson(list.toArray(new String[list.size()]));
    }

    public static String implodeJson(String[] list) {
        StringBuilder b = new StringBuilder();

        b.append("[");

        for (int x = 0; x < list.length; x++) {
            b.append(wrapString(list[x], "\""));

            if (x + 1 != list.length) {
                b.append(",");
            }
        }

        b.append("]");

        return b.toString();
    }

    @SuppressWarnings("all")
    public static String jsonParamater(String name, Object item){
        StringBuilder b = new StringBuilder();
        
        b.append(name).append(":");
        
        if(item == null){
            b.append(jsonWrapString("null"));
        } else if(item instanceof String){
            b.append(jsonWrapString((String)item));
        } else if(item instanceof List<?>){
            try{
                b.append(implodeJson((List<String>)item));
            } catch(Exception e){
                b.append(serializeJsonList((List<?>)item));
            }
        } else {
            b.append(item.toString());
        }
        
        return b.toString();
    }
}
