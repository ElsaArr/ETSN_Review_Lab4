package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static void searchStringInFile(String patternSearch, String path) throws FileNotFoundException {
        String line;
        Pattern pattern = Pattern.compile(patternSearch);
        try {
            FileReader fileReader= new FileReader(path, StandardCharsets.UTF_8);
            BufferedReader file=new BufferedReader(fileReader);
            line = file.readLine();
            while (line!=null){
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()){
                    System.out.println("Pattern found in line: "+line);
                }
                line=file.readLine();
            }
            file.close();
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
