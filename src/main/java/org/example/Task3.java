//3* . Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        List<Map<String, String>> students =
                jsonMapper.readValue(new File("src/main/resources/Task3.json"),
                        new TypeReference<>() {
                        });
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> student : students) {
            int count = 0;
            for (Map.Entry<String, String> pair : student.entrySet()) {
                if (count == 0) {
                    sb.append("Студент ").append(pair.getValue());
                    count++;
                } else if (count == 1) {
                    sb.append(" получил ").append(pair.getValue());
                    count++;
                } else
                    sb.append(" по предмету ").append(pair.getValue()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
