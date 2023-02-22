//2 . Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл
package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        int[] array = init_array();
        String path = create_file();
        get_log(array,path);
        }
    public static int[] init_array(){ // Создание массива с рандомными числами
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt(10,20);
        System.out.println(Arrays.toString(array));
        return array;
    }
    public static String create_file() throws IOException { // Создание файла, если его нет
        String pathFile = null;
        try {
            String pathProj = System.getProperty("user.dir");
            pathFile = pathProj.concat("/log.txt");
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже есть");
            }
        } catch (Exception e) {
            System.out.println("Ошибка");
        } finally {
            System.out.println("Финиш");
        }
        return pathFile;
    }

    public static void get_log(int[] arr, String path) throws IOException { // Запись лога в файл
        Logger logger = Logger.getLogger(Task2.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler(path);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        for (int i = 0; i < arr.length; i++) { // Сортировка пузырьком
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            logger.info(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
