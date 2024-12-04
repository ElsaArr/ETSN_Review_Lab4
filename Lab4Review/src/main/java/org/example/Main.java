package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String []args)
    {
        // Put your path in a private enum with the same model
        // as PublicPathsEnum and call it PrivatePathsEnum
        String path = PrivatePathsEnum.FILE_PATH_TEST_ERRORS.getPath();
//        String searchedPattern = "<\\w>";
        String searchedPattern = "type";
        String request = "search -v-i " + searchedPattern + " " + path;

        try {
            System.out.println("Results for the request : " + request);
            FileUtils.searchInFile(request);
        } catch (FileNotFoundException | InvalidRequestException e) {
            throw new RuntimeException(e);
        }
    }

}