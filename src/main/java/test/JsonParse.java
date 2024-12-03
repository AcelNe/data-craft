package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class JsonParse {

    public static void main(String[] args) {
        System.out.println("==============");
        parsing();
    }

    static void parsing() {
        File f = new File("D:/2024/temp/jsonparse.json5");
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String jsonStr = reader.readLine();
            System.out.println(jsonStr);

            ObjectMapper mapper = new ObjectMapper();
            Person p = mapper.readValue(f,Person.class);
            System.out.println(p.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static class Person {
        private String name;
        private String age;
        private String list;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        public void setList(String list) {
            this.list = list;
        }

        public String getList() {
            return list;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", list='" + list + '\'' +
                    '}';
        }
    }
}