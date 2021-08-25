package com.epam.jwd.task2;

import com.epam.jwd.task2.controller.TextController;

public class Runner {
    private static String encoding = "UTF-8";
    private static String filePathRead = "src\\main\\resources\\inputText";
    private static String filePathWrite = "src\\main\\resources\\outputText";

    public static void main(String[] args) {
        new TextController().run(filePathRead, encoding, filePathWrite);
    }
}
