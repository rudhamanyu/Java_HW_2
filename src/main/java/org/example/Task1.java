package org.example;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        Map<String, String> students = jsonMapper.readValue(new File("src/main/resources/Task1.json"), HashMap.class);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : students.entrySet()) {
            if(!pair.getValue().equals("null"))
                sb.append(pair.getKey()).append(" - ").append(pair.getValue()).append("\n");
        }
        System.out.print(sb);
    }
}