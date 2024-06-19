package work.encrypt.cnet;

import com.google.gson.JsonObject;

public class Base64Encrypt {

    final static String SECRET_KEY = "jm7Gx^1*&qfKEy@^OeIyoCKIgZzK#r4N";
    public static void main(String[] args) {
        System.out.println("Base64 Encrypt main");
        System.out.println(SECRET_KEY);


        //json 객체 생성
        JsonObject jsonData = new JsonObject();

        jsonData.addProperty("account","user04");
        jsonData.addProperty("password","user!234");
        jsonData.addProperty("ssaid","8202536f00d99148");

        System.out.println(jsonData.toString());
    }
}
