//4*. К калькулятору из предыдущего дз добавить логирование.
package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) throws IOException {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter an action: ");
        String data = scr.nextLine();
        double res = 0;
        Logger logger = Logger.getLogger(Task4.class.getName());
        logger.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("calc_log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        try {
            if (data.contains("+")){
                String[] arr = data.split("\\+");
                res = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            }
            else if (data.contains("-")){
                String[] arr = data.split("-");
                res = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
            }
            else if (data.contains("/")){
                String[] arr = data.split("/");
                res =Double.parseDouble(arr[0]) / Integer.parseInt(arr[1]);
            }
            else if (data.contains("*")){
                String[] arr = data.split("\\*");
                res = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
            }
            String r = Double.toString(res);
            String[] ar = r.replace(".", " ").split(" ");
            if (Integer.parseInt(ar[1]) == 0) {
                System.out.print("Результат: " + ar[0] + "\n");
                logger.info("Результат: " + ar[0]);
            }
            else {
                System.out.print("Результат:" + res + "\n");
                logger.info(String.valueOf(res));
            }
        }catch (Exception e){
            logger.warning(e.toString());
        }finally {
            scr.close();
        }
    }
}