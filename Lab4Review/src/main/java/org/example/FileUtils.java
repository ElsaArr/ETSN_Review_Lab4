package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FileUtils class contains methods to search for a pattern in a file
 */
public class FileUtils {

    /**
     * searchPatternInFile method searches for a pattern in a file
     * @param pattern the pattern to search for
     * @param path the path of the file to search in
     * @param reverse if true, the method will print the lines where the pattern is not found
     */
    public static void searchPatternInFile(Pattern pattern, String path, boolean reverse) {
        String line;
        try {
            FileReader fileReader= new FileReader(path, StandardCharsets.UTF_8);
            BufferedReader file=new BufferedReader(fileReader);
            line = file.readLine();
            while (line!=null){
                Matcher matcher = pattern.matcher(line);
                if (reverse) {
                    if (!matcher.find()) {
                        System.out.println("Pattern not found in line: "+line);
                    }
                } else
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

    /**
     * searchStringInFile method searches for a pattern in a file
     * @param patternSearched
     * @param path
     * By default, the search is case sensitive
     */
    public static void searchStringInFile(String patternSearched, String path) {
        Pattern pattern = Pattern.compile(patternSearched);
        searchPatternInFile(pattern, path, false);
    }

    /**
     * searchStringInFileCaseInsensitive method searches for a pattern in a file
     * @param patternSearched
     * @param path
     */
    public static void searchStringInFile(String patternSearched, String path, boolean reverse) {
        Pattern pattern = Pattern.compile(patternSearched);
        searchPatternInFile(pattern, path, reverse);
    }

    /**
     * searchStringInFileCaseInsensitive method searches for a pattern in a file
     * with case insensitive search
     * @param patternSearched
     * @param path
     */
    public static void searchStringInFileCaseInsensitive(String patternSearched, String path) {
        Pattern pattern = Pattern.compile(patternSearched, Pattern.CASE_INSENSITIVE);
        searchPatternInFile(pattern, path, false);
    }

    /**
     * searchStringInFileCaseInsensitive method searches for a pattern in a file
     * with case insensitive search
     * @param patternSearched
     * @param path
     * @param reverse if true, the method will print the lines where the pattern is not found
     */
    public static void searchStringInFileCaseInsensitive(String patternSearched, String path, boolean reverse) {
        Pattern pattern = Pattern.compile(patternSearched, Pattern.CASE_INSENSITIVE);
        searchPatternInFile(pattern, path, reverse);
    }

    /**
     * searchInFile method searches for a pattern in a file
     * @param request syntax : search [-i] [-v] [-v-i] [-i-v] pattern file.txt
     * @throws FileNotFoundException if the file is not found or readable
     * @throws InvalidRequestException if the request is invalid
     */
    public static void searchInFile(String request) throws FileNotFoundException, InvalidRequestException {
        String regexSeparator = " ";
        String[] requestWords = request.split(regexSeparator);

        String regexExtensionFile = ".txt";

        if (requestWords.length < 3 || requestWords.length > 4) {
            throw new InvalidRequestException("Invalid request, not enough or too many arguments");
        }

        if (requestWords[0].equals("search") && requestWords[requestWords.length-1].endsWith(regexExtensionFile)) {
            if (requestWords.length == 3 ) {
                searchStringInFile(requestWords[1], requestWords[2]);
            } else {
                if (requestWords[1].equals("-i")) {
                    searchStringInFileCaseInsensitive(requestWords[2], requestWords[3]);
                }
                else if (requestWords[1].equals("-v")) {
                    searchStringInFile(requestWords[2], requestWords[3], true);
                }
                else if (requestWords[1].equals("-v-i") || requestWords[1].equals("-i-v")) {
                    searchStringInFileCaseInsensitive(requestWords[2], requestWords[3], true);
                } else {
                    throw new InvalidRequestException("Invalid request, additional argument not recognized");
                }
            }
        } else {
            throw new InvalidRequestException("Invalid request, search keyword not found");
        }
    }
}
