package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSONUtil {
    public static JsonObject createJsonData() {
        //json 최상위 객체 생성
        JsonObject jsonData = new JsonObject();
        return jsonData;
    }

    public JsonObject setTestData(JsonObject jsonData) {
        /**
         * value로 단순 값(string, int)를 가지는 프로퍼티 처리.
         * product_no
         * product_name
         */
        jsonData.addProperty("product_no", 1022);
        jsonData.addProperty("product_name", "Shirt");

        /**
         * value로 Json을 가지는 프로퍼티 처리.
         * extra_product_info JSONObject 생성
         */
        JsonObject extraProductInfo = new JsonObject();
        extraProductInfo.addProperty("ship_fee", 3000);
        extraProductInfo.addProperty("discount_rate", 11);
        jsonData.add("extra_product_info", extraProductInfo);

        /**
         * value로 Array를 가지는 프로퍼티 처리.
         * item_list JSONArray 생성
         */
        JsonArray itemList = new JsonArray();

        /**
         * value로 Json을 가지는 프로퍼티 처리.
         * item_list.* JSONObject 생
         */
        JsonObject item1 = new JsonObject();
        item1.addProperty("item_no", 21);
        item1.addProperty("item_name", "L/Blue");
        itemList.add(item1);
        JsonObject item2 = new JsonObject();
        item2.addProperty("item_no", 126);
        item2.addProperty("item_name", "S/Red");
        itemList.add(item2);
        JsonObject item3 = new JsonObject();
        item3.addProperty("item_no", 1052);
        item3.addProperty("item_name", "XL/Green");
        itemList.add(item3);
        jsonData.add("item_list", itemList);

        return jsonData;
    }

    public static String jsonToString(JsonObject jsonObject)
    {
        return jsonObject.toString();
    }
}
