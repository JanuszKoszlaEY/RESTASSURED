package com.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class JsonPayloads {


    public static Map<String,Object> jsonFromJavaMap(){
        Map<String, Object> bookingDates = new HashMap<>(Map.of("checkin", "2020-03-25", "checkout", "2020-03-27"));
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("firstname", "Janusz");
        jsonAsMap.put("lastname", "Kowalski");
        jsonAsMap.put("totalprice", 200);
        jsonAsMap.put("depositpaid", false);
        jsonAsMap.put("bookingdates", bookingDates);
        jsonAsMap.put("additionalneeds", "Food");
        return jsonAsMap;
    }

    public static String jsonString(String firstname, String lastname, Integer totalprice, Boolean depositpaid, String additionalneeds){

        return "{\n" +

            "    \"firstname\": \"" +firstname+ "\",\n" +

            "    \"lastname\": \""+lastname+"\",\n" +

            "    \"totalprice\": \""+totalprice+"\",\n" +

            "    \"depositpaid\": "+depositpaid+",\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkout\": \"2020-03-27\",\n" +
            "        \"checkin\": \"2020-03-25\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \""+additionalneeds+"\"\n" +
            "}";
    }

    public static String jsonPureString(){
        String jsonStr = """
            {
                "firstname": "Janusz",
                "lastname": "Json",
                "totalprice": "150",
                "depositpaid": false,
                "bookingdates": {
                    "checkout": "2020-03-27",
                    "checkin": "2020-03-25"
                },
                "additionalneeds": "Parking"
            }""";


        return jsonStr;
    }

    public static String myJsonObject(){
        String jsonStr = """
            {
                "firstname": "Janusz",
                "lastname": "Json",
                "totalprice": "150",
                "depositpaid": false,
                "bookingdates": {
                    "checkout": "2020-03-27",
                    "checkin": "2020-03-25"
                },
                "additionalneeds": "Parking"
            }""";

        JSONObject jsonObj = new JSONObject(jsonStr);
        jsonObj.put("firstname","Jacek");
        return jsonObj.toString();
    }
}
