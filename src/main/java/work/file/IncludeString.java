package work.file;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IncludeString {
    public static void main(String[] args) {
        Path path = Paths.get("D:/2024/temp/user_metric.part0000.jsonl");
        JSONParser parser = new JSONParser();

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))){
            String line = null;
            while ((line = br.readLine()) != null) {
                JSONObject obj = (JSONObject) parser.parse(line);
                System.out.println(obj.get("account_name"));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
