package com.example.demo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Data {

    Map<String, ArrayList<String>> list;
    String fileName;
    Path path;

    public Data(){
        Map<String, ArrayList<String>> list = new LinkedHashMap<>();
        String fileName = "lab_16.txt";
        Path path = Paths.get(fileName);
    }

    public Map<String, ArrayList<String>> getData() throws IOException {
        list = new LinkedHashMap<>();
        fileName = "lab_16.txt";
        path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        String heading = scanner.nextLine();

        while (scanner.hasNext()){
            ArrayList<String> values = new ArrayList<>();
            String value = scanner.nextLine();
            values.add(value);
            while (value.startsWith("    ") && scanner.hasNext()){
                value = scanner.nextLine();
                if(value.startsWith("    "))
                    values.add(value);
            }
            heading = deletePointer(heading);
            list.put(heading, values);
            heading = value;
        }
        return list;
    }

    public String deletePointer(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
