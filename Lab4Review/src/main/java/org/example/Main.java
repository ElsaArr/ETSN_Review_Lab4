package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String []args)
    {
        // Put your path in a private enum with the same model
        // as PublicPathsEnum and call it PrivatePathsEnum
        String path = PrivatePathsEnum.FILE_PATH_TEST_ERRORS.getPath();
        String searchPattern = "<\\w>";
//        String searchPattern = "type";

        try {
            FileUtils.searchStringInFile(searchPattern, path) ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}