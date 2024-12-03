package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDto;

import java.io.File;
import java.io.IOException;

public class JsonName {
    public static void main(String[] args) {
        call();
    }

    static void call() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("D:/2024/temp/user1.json");

            UserDto dto = mapper.readValue(jsonFile, UserDto.class);
            System.out.println(dto.getName());
            System.out.println(dto.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}