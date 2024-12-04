package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String []args)
    {
        // Put your path in a private enum with the same model
        // as PublicPathsEnum and call it PrivatePathsEnum
        String path = PrivatePathsEnum.FILE_PATH_TEST_ERRORS.getPath();
        String searchWord = "type";

        try {
            FileUtils.searchStringInFile(searchWord, path) ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}