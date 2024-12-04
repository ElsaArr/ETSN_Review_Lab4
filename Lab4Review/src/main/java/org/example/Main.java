package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String []args)
    {
        String path = "C:\\Users\\elsaa\\Documents\\Centrale\\LTH\\ETSN20\\Labs\\Lab4\\testTexte1.txt";
        String searchWord = "Type";

        try {
            FileUtils.searchStringInFile(searchWord, path) ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}